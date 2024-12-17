import tkinter as tk
from tkinter import ttk, scrolledtext
import time

class Process:
    def __init__(self, pid, arrival_time, burst_time):
        self.pid = pid
        self.arrival_time = arrival_time
        self.burst_time = burst_time
        self.remaining_time = burst_time
        self.priority = 0
        self.progress_label = None  # Para mostrar el porcentaje

    def __str__(self):
        return f"PID={self.pid}, Llegada={self.arrival_time}, Duración={self.burst_time}, Restante={self.remaining_time}"

class MultilevelFeedbackQueueScheduler:
    def __init__(self, root):
        self.root = root
        self.root.title("Simulador MLFQ")
        self.root.configure(bg='#f0f0f0')  # Color de fondo
        
        # Configuración de estilo
        self.style = ttk.Style()
        self.style.configure("Custom.TEntry", padding=5)
        self.style.configure("Custom.TButton", padding=5)
        self.style.configure("Custom.Horizontal.TProgressbar", 
                           background='#0078D7',
                           troughcolor='#E1E1E1',
                           bordercolor='#0078D7')
        
        self.processes = []
        self.quantum1 = 2
        self.quantum2 = 4
        self.levels = {0: "Nivel 1 (RR Q=2)", 1: "Nivel 2 (RR Q=4)", 2: "Nivel 3 (SJF)"}

        self.setup_ui()

    def setup_ui(self):
        # Frame principal
        main_frame = tk.Frame(self.root, bg='#f0f0f0')
        main_frame.pack(padx=20, pady=20, fill=tk.BOTH, expand=True)

        # Título con estilo mejorado
        title_frame = tk.Frame(main_frame, bg='#0078D7', pady=15)
        title_frame.pack(fill=tk.X)
        title_label = tk.Label(
            title_frame, 
            text="Simulación del Algoritmo Multinivel con Retroalimentación",
            font=("Helvetica", 18, "bold"),
            fg='white',
            bg='#0078D7'
        )
        title_label.pack()

        # Frame para entradas
        input_frame = tk.Frame(main_frame, bg='#f0f0f0')
        input_frame.pack(pady=20)

        # Entradas separadas
        entries_frame = tk.Frame(input_frame, bg='#f0f0f0')
        entries_frame.pack()

        # PID
        pid_label = tk.Label(entries_frame, text="PID:", bg='#f0f0f0', font=("Helvetica", 10))
        pid_label.grid(row=0, column=0, padx=5, pady=5)
        self.pid_entry = ttk.Entry(entries_frame, width=15)
        self.pid_entry.grid(row=0, column=1, padx=5, pady=5)

        # Tiempo de llegada
        arrival_label = tk.Label(entries_frame, text="Tiempo de llegada:", bg='#f0f0f0', font=("Helvetica", 10))
        arrival_label.grid(row=0, column=2, padx=5, pady=5)
        self.arrival_entry = ttk.Entry(entries_frame, width=15)
        self.arrival_entry.grid(row=0, column=3, padx=5, pady=5)

        # Tiempo de ráfaga
        burst_label = tk.Label(entries_frame, text="Tiempo de ráfaga:", bg='#f0f0f0', font=("Helvetica", 10))
        burst_label.grid(row=0, column=4, padx=5, pady=5)
        self.burst_entry = ttk.Entry(entries_frame, width=15)
        self.burst_entry.grid(row=0, column=5, padx=5, pady=5)

        # Botones
        buttons_frame = tk.Frame(input_frame, bg='#f0f0f0')
        buttons_frame.pack(pady=10)

        add_process_btn = tk.Button(
            buttons_frame,
            text="Agregar Proceso",
            command=self.add_process,
            bg='#0078D7',
            fg='white',
            font=("Helvetica", 10),
            relief=tk.FLAT,
            padx=10
        )
        add_process_btn.pack(side=tk.LEFT, padx=5)

        start_sim_btn = tk.Button(
            buttons_frame,
            text="Iniciar Simulación",
            command=self.start_simulation,
            bg='#0078D7',
            fg='white',
            font=("Helvetica", 10),
            relief=tk.FLAT,
            padx=10
        )
        start_sim_btn.pack(side=tk.LEFT, padx=5)

        # Frame para barras de progreso
        self.progress_frame = tk.Frame(main_frame, bg='#f0f0f0')
        self.progress_frame.pack(pady=10, fill=tk.X)

        # Área de logs
        self.log_area = scrolledtext.ScrolledText(
            main_frame,
            width=60,
            height=15,
            font=("Consolas", 10)
        )
        self.log_area.pack(pady=10)

        # Botón de reinicio
        reset_btn = tk.Button(
            main_frame,
            text="Reiniciar Simulación",
            command=self.reset_simulation,
            bg='#FF4444',
            fg='white',
            font=("Helvetica", 10, "bold"),
            relief=tk.FLAT,
            padx=10
        )
        reset_btn.pack(pady=10)

    def add_process(self):
        """Añadir un proceso con la entrada del usuario"""
        try:
            pid = self.pid_entry.get()
            arrival_time = int(self.arrival_entry.get())
            burst_time = int(self.burst_entry.get())
            
            process = Process(pid, arrival_time, burst_time)
            self.processes.append(process)
            self.create_progress_bar(process)
            self.log(f"Proceso añadido: {process}")
            
            # Limpiar entradas
            self.pid_entry.delete(0, tk.END)
            self.arrival_entry.delete(0, tk.END)
            self.burst_entry.delete(0, tk.END)
        except ValueError:
            self.log("Error: Por favor ingrese valores válidos")

    def create_progress_bar(self, process):
        """Crear barra de progreso para cada proceso"""
        frame = tk.Frame(self.progress_frame, bg='#f0f0f0')
        frame.pack(fill=tk.X, pady=5, padx=20)

        # Label para el PID
        label = tk.Label(frame, text=f"PID={process.pid}", bg='#f0f0f0', width=10)
        label.pack(side=tk.LEFT, padx=5)

        # Barra de progreso
        progress_bar = ttk.Progressbar(
            frame,
            style="Custom.Horizontal.TProgressbar",
            maximum=process.burst_time,
            length=300
        )
        progress_bar.pack(side=tk.LEFT, padx=5)
        process.progress_bar = progress_bar

        # Label para el porcentaje
        process.progress_label = tk.Label(frame, text="0%", bg='#f0f0f0', width=8)
        process.progress_label.pack(side=tk.LEFT, padx=5)

    def start_simulation(self):
        """Iniciar la simulación del algoritmo multinivel con retroalimentación"""
        if not self.processes:
            self.log("Error: No hay procesos para simular")
            return
            
        self.log("Iniciando simulación...")
        self.root.after(0, self.simulation_step, 0, [])

    def simulation_step(self, tiempo, ready_queue):
        """Ejecuta un paso de la simulación"""
        if not any(p.remaining_time > 0 for p in self.processes) and not ready_queue:
            self.log("Simulación finalizada.")
            return

        for process in self.processes:
            if process.arrival_time == tiempo and process.remaining_time > 0:
                ready_queue.append(process)
                self.log(f"{process} llega al sistema y se añade a {self.levels[process.priority]}.")

        if ready_queue:
            process = ready_queue.pop(0)
            quantum = self.quantum1 if process.priority == 0 else (self.quantum2 if process.priority == 1 else float('inf'))
            executed_time = min(quantum, process.remaining_time)
            process.remaining_time -= executed_time
            
            progress = (process.burst_time - process.remaining_time) / process.burst_time * 100
            process.progress_bar['value'] = process.burst_time - process.remaining_time
            process.progress_label.config(text=f"{progress:.1f}%")
            
            self.log(f"Ejecutando {process} en {self.levels[process.priority]}, tiempo restante={process.remaining_time}")
            
            if process.remaining_time > 0:
                process.priority = min(2, process.priority + 1)
                ready_queue.append(process)
            
            tiempo += executed_time
        else:
            tiempo += 1

        self.root.after(10, self.simulation_step, tiempo, ready_queue)

    def reset_simulation(self):
        """Reiniciar la simulación"""
        # Limpiar procesos y logs
        self.processes = []
        self.log_area.delete(1.0, tk.END)
        
        # Limpiar barras de progreso
        for widget in self.progress_frame.winfo_children():
            widget.destroy()
        
        self.log("Simulación reiniciada")

    def log(self, message):
        """Función para mostrar los logs en la interfaz"""
        self.log_area.insert(tk.END, message + "\n")
        self.log_area.yview(tk.END)

if __name__ == "__main__":
    root = tk.Tk()
    app = MultilevelFeedbackQueueScheduler(root)
    root.mainloop()