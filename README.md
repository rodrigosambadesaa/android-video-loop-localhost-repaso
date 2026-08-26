# Android localhost video loop - repaso

Reconstrucción moderna del **ejercicio 3 de repaso** de Programación Multimedia y Dispositivos Móviles.

## Enunciado histórico

El ejercicio pedía copiar `video.mp4` a `C:\wamp\www\`, arrancar Wampserver y reproducirlo en bucle
en la parte superior de la interfaz, con una superficie de 100 dp, usando:

`http://10.0.2.2/video.mp4`

`10.0.2.2` es la dirección especial del emulador Android para alcanzar el equipo anfitrión.

## Modernización

- Android 17 / API 37.
- Se conserva el escenario **servidor local + emulador**.
- Para no depender de Wampserver, se incluyen scripts para servir el vídeo con Python.
- El HTTP sin cifrar se limita a `10.0.2.2` mediante `network_security_config`.
- En Android 17 con `targetSdk 37`, se solicita también `ACCESS_LOCAL_NETWORK`.
- `VideoView` + `MediaController`, reintento y bucle con `OnCompletionListener`.
- Se incluye un clip ligero derivado del `video.mp4` histórico recuperado, pensado solo como asset didáctico.

## Ejecutar el servidor

### Linux/macOS

```bash
./scripts/serve-video.sh
```

### Windows PowerShell

```powershell
.\scripts\serve-video.ps1
```

Por defecto se usa el puerto 8000, por lo que la app arranca con:

`http://10.0.2.2:8000/video.mp4`

Si quieres reproducir exactamente el enunciado original, sirve el archivo en el puerto 80 y cambia la URL en la interfaz.
