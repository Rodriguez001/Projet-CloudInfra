FROM node:14 AS node_stage

WORKDIR /app

COPY package*.json .
RUN apt update -y
RUN npm install
COPY . .
RUN npm run build --prod

FROM nginx:alpine

COPY --from=node_stage /app/dist/crud-app /usr/share/nginx/html

EXPOSE 81

CMD ["nginx", "-g", "daemon off;"]

