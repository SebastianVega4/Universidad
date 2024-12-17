class Process:
    def __init__(self, pid, llegada, tiempo_rafaga):
        """
        Clase que representa un proceso.

        Parámetros:
        pid: Identificador único del proceso.
        arrival_time: Tiempo en el que el proceso llega al sistema.
        burst_time: Tiempo que el proceso necesita para completarse (duración total).
        """
        self.pid = pid  # Identificador del proceso
        self.llegada = llegada  # Tiempo de llegada del proceso al sistema
        self.tiempo_rafaga = tiempo_rafaga  # Tiempo de ráfaga o duración total del proceso
        self.restante = tiempo_rafaga  # Tiempo restante para que el proceso finalice
        self.priority = 0  # Prioridad inicial del proceso (nivel más alto)

    def __str__(self):
        """
        Método para representar el estado del proceso como una cadena de texto.
        """
        return (f"PID={self.pid}, Llegada={self.llegada}, Duración={self.tiempo_rafaga}, Restante={self.restante}")


class MLFQAlgorithm:
    def __init__(self, quantum1=2, quantum2=4):
        """
        Clase que implementa el algoritmo de planificación Multilevel Feedback Queue (MLFQ).

        Parámetros:
        quantum1: Quantum del nivel 1 (por defecto 2 unidades de tiempo).
        quantum2: Quantum del nivel 2 (por defecto 4 unidades de tiempo).
        """
        self.quantum1 = quantum1  # Quantum del primer nivel (RR con Q=2)
        self.quantum2 = quantum2  # Quantum del segundo nivel (RR con Q=4)
        self.niveles = {0: "Nivel 1 (Round Robin Q=2)", 1: "Nivel 2 (Round Robin Q=4)", 2: "Nivel 3 (FIFO)"}  # Mapeo de los niveles
        self.procesos = []  # Lista de procesos en el sistema

    def add_process(self, pid, llegada, tiempo_rafaga):
        """
        Añade un nuevo proceso al sistema.

        Parámetros:
        pid: Identificador único del proceso.
        arrival_time: Tiempo en el que el proceso llega al sistema.
        burst_time: Tiempo que el proceso necesita para completarse.

        Retorna:
        El proceso que ha sido añadido.
        """
        process = Process(pid, llegada, tiempo_rafaga)  # Crear un nuevo proceso
        self.procesos.append(process)  # Añadir el proceso a la lista de procesos
        return process  # Devolver el proceso añadido

    def start_simulation(self, log_callback, simulation_step):
        """
        Ejecuta la simulación del algoritmo MLFQ.

        Parámetros:
        log_callback: Función para registrar eventos de la simulación.
        simulation_step: Función para actualizar el progreso del proceso en cada paso.
        """
        proceso_listo = []  # Cola de procesos listos para ser ejecutados
        tiempo = 0  # Reloj global de la simulación

        # Mientras haya procesos que no hayan terminado o haya procesos en la cola de listos
        while any(p.restante > 0 for p in self.procesos) or proceso_listo:
            # Añadir procesos a la cola según el tiempo de llegada
            for procesos in self.procesos:
                if procesos.llegada == tiempo and procesos.restante > 0:
                    proceso_listo.append(procesos)  # Añadir proceso a la cola de listos
                    log_callback(f"{procesos} llega al sistema y se añade a {self.niveles[procesos.priority]}.")  # Registrar la llegada

            if proceso_listo:
                procesos = proceso_listo.pop(0)  # Sacar el primer proceso de la cola

                # Asignar quantum dependiendo de la prioridad del proceso
                quantum = self.quantum1 if procesos.priority == 0 else (
                    self.quantum2 if procesos.priority == 1 else float('inf'))

                # Ejecutar el proceso por el tiempo del quantum o hasta que termine
                tiempo_ejecucion = min(quantum, procesos.restante)
                procesos.restante -= tiempo_ejecucion  # Reducir el tiempo restante del proceso

                # Calcular el progreso del proceso en porcentaje
                progress = (procesos.tiempo_rafaga - procesos.restante) / procesos.tiempo_rafaga * 100
                simulation_step(procesos, progress)  # Actualizar el progreso con el callback

                log_callback(
                    f"Ejecutando {procesos} en {self.niveles[procesos.priority]}, tiempo restante={procesos.restante}"
                )  # Registrar la ejecución

                if procesos.restante > 0:  # Si el proceso no ha terminado
                    procesos.priority = min(2, procesos.priority + 1)  # Aumentar la prioridad (bajar de nivel)
                    proceso_listo.append(procesos)  # Añadir el proceso de nuevo a la cola de listos
                tiempo += tiempo_ejecucion  # Actualizar el reloj global según el tiempo ejecutado
            else:
                tiempo += 1  # Si no hay procesos listos, avanzar el reloj global en 1 unidad de tiempo

        # Cuando todos los procesos han finalizado
        log_callback("Simulación finalizada.")  # Registrar la finalización
