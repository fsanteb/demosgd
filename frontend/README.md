# GDPNP - Frontend

Este proyecto ha sido generado con Angular CLI version 8.0.2

## Servidor de desarrollo

Ejecutar `npm install` para instalar todas las dependencias del `package.json`.

Ejecutar `ng serve` para el servidor de desarrollo. Ir a `http://localhost:4200/`.

## Compilación para distribución

### Desarrollo
```bash
$  ng build --prod --aot --base-href /gdpnp/ --deploy-url /gdpnp/ --configuration=desarrollo
```
### Calidad
```bash
$  ng build --prod --aot --base-href /gdpnp/ --deploy-url /gdpnp/ --configuration=calidad
```
### Producción
```bash
$  ng build --prod --aot --base-href /gdpnp/ --deploy-url /gdpnp/ --configuration=production
```

## Tecnologías

- Angular 8.0.0
- Angular Material 8.0.1
- Fontawesome-free 5.9.0
- Bootstrap 4.3.1 (sólo sistema de grilla).
- Sass 1.22.0
