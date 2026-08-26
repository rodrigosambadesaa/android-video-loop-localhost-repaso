# Enunciado original — Ejercicio 3 de repaso: vídeo desde localhost

Reconstrucción moderna del ejercicio 3 de repaso de Programación Multimedia y Dispositivos Móviles.

El ejercicio histórico pide copiar `video.mp4` a `C:\wamp\www\`, arrancar Wampserver y reproducir ese vídeo **en bucle** en la parte superior de la interfaz Android, utilizando una superficie de 100 dp y la URL:

```text
http://10.0.2.2/video.mp4
```

`10.0.2.2` es la dirección especial utilizada por el emulador Android para acceder al equipo anfitrión.

La versión actual mantiene el escenario servidor local + emulador, pero permite servir el vídeo con los scripts incluidos en el repositorio y restringe el HTTP sin cifrar al host local de desarrollo.

No existe una base de datos asociada al ejercicio.
