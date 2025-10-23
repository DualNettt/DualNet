DualNet - einfache statische Startseite

Diese kleine Änderung fügt eine statische HTML-Startseite hinzu:

- src/main/resources/static/index.html

Wie du das Projekt startest (lokal):

1. Ausführen mit dem mitgelieferten Maven-Wrapper:

   ./mvnw spring-boot:run

2. Oder das Paket bauen und starten:

   ./mvnw package
   java -jar target/*.jar
<!doctype html>
Die Seite ist dann im Browser unter http://localhost:8080/ verfügbar (index wird automatisch geliefert).

HINWEIS: Ich habe nur eine kleine, statische Seite hinzugefügt. Wenn du möchtest, kann ich zusätzlich einen Controller oder weitere Endpunkte anlegen.
<html lang="de">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <title>DualNet - Startseite</title>
  <style>
    body { font-family: system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial; margin: 0; padding: 0; display: flex; align-items: center; justify-content: center; height: 100vh; background: linear-gradient(135deg,#f0f4ff,#e8fff4); }
    .card { background: white; padding: 2rem 2.5rem; border-radius: 12px; box-shadow: 0 6px 18px rgba(0,0,0,0.08); max-width: 680px; text-align: center; }
    h1 { margin: 0 0 0.5rem; color: #0b62d6; }
    p { margin: 0.5rem 0 1rem; color: #333; }
    a { color: #0b62d6; text-decoration: none; font-weight: 600; }
    footer { margin-top: 1.25rem; font-size: 0.9rem; color: #666; }
  </style>
</head>
<body>
  <div class="card">
    <h1>Willkommen bei DualNet</h1>
    <p>Das ist eine ganz einfache statische Startseite, die im Spring Boot-Projekt unter <code>/index.html</code> bereitgestellt wird.</p>
    <p>Du kannst diese Datei anpassen unter:<br><code>src/main/resources/static/index.html</code></p>
    <a href="https://spring.io/projects/spring-boot" target="_blank" rel="noopener">Mehr über Spring Boot</a>
    <footer>Viel Erfolg — die Seite ist sofort erreichbar, wenn die App läuft.</footer>
  </div>
</body>
</html>

