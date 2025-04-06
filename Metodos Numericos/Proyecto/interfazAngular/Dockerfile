# Usa una imagen base de Node.js específica (versión 18.x.x LTS Alpine)
FROM node:18-alpine as build

# Establece el directorio de trabajo en el contenedor
WORKDIR /usr/src/app

# Copia el archivo package.json y el archivo de lock de npm
COPY package*.json ./

# Instala las dependencias del proyecto
RUN npm install

# Instala @angular/cli globalmente
RUN npm install -g @angular/cli

# Copia todos los archivos del proyecto al directorio de trabajo en el contenedor
COPY . .

# Construye la aplicación Angular para producción
RUN npm run build -- --output-path=dist

# Usa una imagen base de Nginx (versión Alpine) para servir la aplicación
FROM nginx:alpine

# Copia el archivo de configuración de Nginx
COPY nginx.conf /etc/nginx/nginx.conf

# Copia los archivos construidos de Angular desde el contenedor de Node.js al directorio de Nginx
COPY --from=build /usr/src/app/dist /usr/share/nginx/html

# Expone el puerto 5009 para el servidor web
EXPOSE 5009

# Inicia Nginx cuando se ejecute el contenedor
CMD ["nginx", "-g", "daemon off;"]
