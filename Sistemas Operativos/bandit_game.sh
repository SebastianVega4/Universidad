#!/bin/bash

#Ruta base
BASE_DIR="$(dirname "$(realpath "$0")")/bandit_game"

# Crear directorios y demas
mkdir -p "$BASE_DIR/nivel1"
echo "Passwordnivel1" > "$BASE_DIR/nivel1/nivel1.txt"

mkdir -p "$BASE_DIR/nivel2"
echo -e "juego bandit \n pass= nivel2password \n pass \n no es contrasena \n mas linea \n por rellenar \n blablabla \n ect " > "$BASE_DIR/nivel2/nivel2.txt"

mkdir -p "$BASE_DIR/nivel3"
echo "Passwordnivel3" > "$BASE_DIR/nivel3/nivel3.txt"
tar -czf "$BASE_DIR/nivel3/nivel3.tar.gz" -C "$BASE_DIR/nivel3" nivel3.txt
rm "$BASE_DIR/nivel3/nivel3.txt"

mkdir -p "$BASE_DIR/nivel4"
echo "UGFzc3dvcmRuZXZlbDQ=" | base64 --decode > "$BASE_DIR/nivel4/nivel4.b64"

mkdir -p "$BASE_DIR/nivel5"
echo "Passwordnivel5" | sudo tee "$BASE_DIR/nivel5/nivel5.txt" > /dev/null
sudo chmod 400 "$BASE_DIR/nivel5/nivel5.txt"

mkdir -p "$BASE_DIR/nivel6/.hidden"
echo "Passwordnivel6" > "$BASE_DIR/nivel6/.hidden/.secretfile"

mkdir -p "$BASE_DIR/nivel7"
echo "Passwordnivel7" > "$BASE_DIR/nivel7/nivel7.txt"
openssl enc -aes-256-cbc -salt -in "$BASE_DIR/nivel7/nivel7.txt" -out "$BASE_DIR/nivel7/nivel7.enc" -k sebastian
rm "$BASE_DIR/nivel7/nivel7.txt"

mkdir -p "$BASE_DIR/nivel8"
echo "secretpassword" > "$BASE_DIR/nivel8/.password"
echo "Passwordnivel8" > "$BASE_DIR/nivel8/nivel8.txt"
zip -P $(cat "$BASE_DIR/nivel8/.password") "$BASE_DIR/nivel8/nivel8.zip" "$BASE_DIR/nivel8/nivel8.txt"
rm "$BASE_DIR/nivel8/nivel8.txt"

# Ejecutar cada nivel
run_level() {
    local level=$1
    local password=$2
    local message=$3
    local level_dir="$BASE_DIR/nivel$level"

    # Cambiar al directorio del nivel correspondiente
    cd "$level_dir" || exit
    echo "$message"
    echo " "
    echo "Estás en el nivel $level. Escribe tus comandos para encontrar la contraseña o ingresa 'exit' para terminar el nivel."
    echo " "

    # Abrir una subshell para poder hacer comandos
    while true; do
        read -p "Sebastian comand :)> " cmd
        if [ "$cmd" == "exit" ]; then
            break
        else
            eval "$cmd"
        fi
    done

    # Validar contraseña
    read -sp "Ingresa la contraseña encontrada: " input_password
    echo

    if [ "$input_password" == "$password" ]; then
        echo "¡Correcto! Avanzas al siguiente nivel."
    echo " **************************************************************************"
    else
        echo " "
        echo " ---------------------------------------------------------------------------"
        echo "Contraseña incorrecta. Intenta el nivel de nuevo."
        run_level "$level" "$password" "$message"
        echo " ---------------------------------------------------------------------------"
        echo " "
    fi
}

# Mensajes y contraseñas de cada nivel
echo " +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
echo "Bienvenido al juego de Sebastian. Sigue las instrucciones de cada nivel para encontrar las contraseñas y avanzar."
echo " +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
echo " "

run_level 1 "Passwordnivel1" "Nivel 1: La contraseña se encuentra en el archivo nivel1.txt"
run_level 2 "nivel2password" "Nivel 2: Busca en el archivo nivel2.txt la línea que contiene la palabra 'pass=' "
run_level 3 "Passwordnivel3" "Nivel 3: Descomprime el archivo nivel3 y encuentra la contraseña"
run_level 4 "Passwordnivel4" "Nivel 4: Decodifica el archivo nivel4 en formato Base64"
run_level 5 "Passwordnivel5" "Nivel 5: Solo el usuario admin puede acceder al archivo nivel5 para encontrar la contraseña"
run_level 6 "Passwordnivel6" "Nivel 6: Encuentra el archivo oculto para obtener la contraseña"
run_level 7 "Passwordnivel7" "Nivel 7: Utiliza openssl para desencriptar el archivo nivel7 usando 'sebastian' como clave, para encontrar la contraseña."
run_level 8 "Passwordnivel8" "Nivel 8: Usa la contraseña almacenada en .password para descomprimir el archivo nivel8.zip y encontrar la contraseña en el archivo descomprimido."

echo "¡Felicitaciones! Has completado todos los niveles."

