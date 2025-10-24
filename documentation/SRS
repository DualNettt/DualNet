# Softwareanforderungsspezifikation (SRS) – DualNet

## 1. Einleitung

### 1.1 Übersicht
DualNet ist eine Social-Media-Plattform, die primär für Studierende der DHBW konzipiert ist.

**Alleinstellungsmerkmale:**
- Fokus auf Studierende (Campus-spezifische Gruppen und Veranstaltungen)
- Einfache, datenschutzorientierte Grundstruktur mit späterer Datenbankanbindung
- Intuitive Benutzeroberfläche (Login/Register, Beiträge, Nachrichten)

### 1.2 Geltungsbereich
Dieses Dokument beschreibt die Softwareanforderungen für das DualNet-System auf funktionaler und nicht-funktionaler Ebene.  
Es deckt die Kernfunktionen einer Social-Media-Plattform ab (Authentifizierung, Nutzerprofile, Beiträge, Interaktionen, Messaging) und enthält Hinweise zu möglichen Erweiterungen (z. B. Datenbankanbindung, Moderation).  
Technische Implementierungsdetails werden in separaten Dokumenten spezifiziert.

### 1.3 Definitionen, Akronyme und Abkürzungen

| Begriff | Bedeutung |
|----------|------------|
| DHBW | Duale Hochschule Baden-Württemberg |
| UI | User Interface (Benutzeroberfläche) |
| Auth | Authentifizierung |
| DB | Datenbank |

### 1.4 Referenzen
- RUP-basierte Vorlagen (intern)  
- Projekt-Repository (Git, Hauptbranch, WebStorm)

---

## 2. Funktionale Anforderungen

### 2.1 Übersicht
DualNet stellt grundlegende Social-Media-Funktionen bereit:  
Registrierung & Login, Profilverwaltung, Beitragsverwaltung, Suche, private Nachrichten und Verbindungen zwischen Nutzern.

Im folgenden **Anwendungsfalldiagramm** werden die zentralen Use Cases mit den Akteuren *Nutzer* und *Administrator* dargestellt.  

> 📎 *[Hier Anwendungsfalldiagramm einfügen]*

---

### 2.2 Anwendungsfall 1 – Authentifizierung (Registrieren / Anmelden)

**Ziel:**  
Ermöglicht neuen Nutzern die Registrierung und bestehenden Nutzern das Login.

**Akteure:**  
Nutzer (nicht authentifiziert)

**Voraussetzungen:**  
Nutzer hat Zugriff auf die Startseite / Loginmaske.

**Nachbedingungen:**  
Bei Erfolg: authentifizierte Session und Weiterleitung auf Profilseite.

**Hauptablauf:**
1. Nutzer öffnet die Login-/Registrierungsseite.  
2. Gibt Anmeldedaten (Username, E-Mail, Passwort) ein.  
3. System prüft Eingaben.  
4. Bei Erfolg wird eine Session erzeugt.  
5. Weiterleitung zum Profil.

**Alternative Abläufe:**
- Eingabefehler → Fehlermeldung  
- Nutzer existiert bereits → Hinweis  

**Diagramme:**  
- *Aktivitätsdiagramm*: zeigt den Ablauf von Dateneingabe, Validierung bis Sessionerstellung.  
- *Sequenzdiagramm*: visualisiert die Interaktion zwischen UI, Auth-Service und Sessionverwaltung.  
Diese Diagramme verdeutlichen, wie Benutzeraktionen mit internen Prozessen verbunden sind.

> 📎 *[Hier Aktivitätsdiagramm & Sequenzdiagramm einfügen]*

---

### 2.3 Anwendungsfall 2 – Profilverwaltung

**Ziel:**  
Nutzer kann persönliche Informationen anzeigen und bearbeiten.

**Akteure:**  
Nutzer (authentifiziert)

**Voraussetzungen:**  
Erfolgreicher Login.

**Nachbedingungen:**  
Profilinformationen aktualisiert (lokal gespeichert, später DB-persistent).

**Hauptablauf:**
1. Nutzer öffnet Profilseite.  
2. Bearbeitet Daten (Name, Bio, Profilbild).  
3. Klick auf „Speichern“.  
4. System validiert und aktualisiert Daten.

**Diagramme:**  
- *Aktivitätsdiagramm*: Bearbeitungsprozess.  
- *Zustandsdiagramm*: Zustandswechsel (*Profil anzeigen → bearbeiten → gespeichert*).  
Das Aktivitätsdiagramm zeigt den Ablauf, das Zustandsdiagramm den internen Profilstatus.

> 📎 *[Hier Aktivitäts- & Zustandsdiagramm einfügen]*

---

### 2.4 Anwendungsfall 3 – Beiträge erstellen und interagieren

**Ziel:**  
Nutzer kann Beiträge erstellen, liken und kommentieren.

**Akteure:**  
Nutzer (authentifiziert)

**Voraussetzungen:**  
Login erforderlich.

**Nachbedingungen:**  
Neuer Beitrag sichtbar im Feed; Interaktionen werden gespeichert.

**Hauptablauf:**
1. Nutzer öffnet Feedseite.  
2. Wählt „Neuen Beitrag erstellen“.  
3. Gibt Text/Bild ein.  
4. Beitrag wird veröffentlicht.  
5. Andere Nutzer können liken oder kommentieren.

**Diagramme:**  
- *Aktivitätsdiagramm*: Ablauf von der Beitragserstellung bis Veröffentlichung.  
- *Sequenzdiagramm*: Interaktion zwischen UI, Feed-Controller und Speicherlogik.  
Gemeinsam zeigen die Diagramme, wie Nutzeraktionen zu sichtbaren Feed-Änderungen führen.

> 📎 *[Hier Aktivitäts- & Sequenzdiagramm einfügen]*

---

### 2.5 Anwendungsfall 4 – Nutzer suchen und verbinden

**Ziel:**  
Ermöglicht die Suche nach anderen Nutzern und das Senden von Verbindungsanfragen.

**Akteure:**  
Nutzer (authentifiziert)

**Voraussetzungen:**  
Login.

**Nachbedingungen:**  
Freundschaftsanfrage gesendet oder Verbindungsstatus aktualisiert.

**Hauptablauf:**
1. Nutzer gibt Suchbegriff ein.  
2. System zeigt Trefferliste.  
3. Nutzer klickt „Verbinden“.  
4. Anfrage wird versendet.  
5. Empfänger kann annehmen oder ablehnen.

**Diagramme:**  
- *Sequenzdiagramm*: Nachrichtenaustausch zwischen zwei Nutzern über den Verbindungsservice.  
- *Zustandsdiagramm*: Zustände einer Verbindung (*offen → angenommen → aktiv*).  
Beide Diagramme beschreiben denselben Prozess aus Ablauf- und Zustandsperspektive.

> 📎 *[Hier Sequenz- & Zustandsdiagramm einfügen]*

---

### 2.6 Anwendungsfall 5 – Private Nachrichten

**Ziel:**  
Direkte Kommunikation zwischen zwei verbundenen Nutzern.

**Akteure:**  
Nutzer (authentifiziert)

**Voraussetzungen:**  
Beide Nutzer existieren und sind verbunden.

**Nachbedingungen:**  
Nachricht ist gespeichert (lokal oder persistent) und Empfänger wird benachrichtigt.

**Hauptablauf:**
1. Nutzer öffnet Chatfenster.  
2. Gibt Nachricht ein.  
3. Klick auf „Senden“.  
4. System überträgt Nachricht an Empfänger.  
5. Nachricht erscheint im Verlauf.

**Alternative Abläufe:**
- Empfänger offline → Nachricht bleibt im Outbox-Puffer.  
- Verbindung verloren → Fehlermeldung.

**Diagramme:**  
- *Sequenzdiagramm*: Kommunikationsfluss zwischen Sender, Empfänger und Nachrichtenservice.  
- *Aktivitätsdiagramm*: beschreibt Eingabe, Versand und Empfang.  
Das Aktivitätsdiagramm zeigt den Benutzerablauf, das Sequenzdiagramm den technischen Datentransfer.

> 📎 *[Hier Sequenz- & Aktivitätsdiagramm einfügen]*

---

### 2.7 (Optional) Anwendungsfall 6 – Moderation / Administration

**Ziel:**  
Administrator kann Nutzer und Inhalte verwalten.

**Akteure:**  
Administrator

**Voraussetzungen:**  
Adminrechte aktiv.

**Nachbedingungen:**  
Beitrag oder Nutzerstatus angepasst.

**Diagramme:**  
- *Aktivitätsdiagramm*: Ablauf z. B. beim Löschen eines Beitrags.  
- *Zustandsdiagramm*: beschreibt Änderungen des Nutzerstatus (*aktiv → gesperrt → gelöscht*).  
Diese Diagramme verdeutlichen den Ablauf der Moderation und den Lebenszyklus verwalteter Objekte.

> 📎 *[Hier Aktivitäts- & Zustandsdiagramm einfügen]*

---

## 3. Nicht-funktionale Anforderungen

| Kategorie | Beschreibung |
|------------|---------------|
| **Benutzerfreundlichkeit** | Intuitives, responsives UI; klare Fehlermeldungen |
| **Zuverlässigkeit** | Authentifizierungsflüsse müssen konsistent funktionieren |
| **Leistung** | Seitenladezeit < 2 s unter Normalbedingungen |
| **Sicherheit** | Gesalzene Passwort-Hashes (BCrypt), Validierung, Schutz vor XSS/CSRF |
| **Wartbarkeit** | Modularer Code, dokumentierte Komponenten, Tests für Kernfunktionen |
| **Flexibilität** | Leicht erweiterbar für spätere DB-Anbindung (z. B. Repository-Pattern) |

---

## 4. Technische Einschränkungen und Annahmen

- Entwicklungsumgebung: **WebStorm**  
- Stack: **React/Vue (Frontend)**, **Node.js/Express (Backend)**  
- Datenbank wird in späterer Version angebunden (aktuell Mock-Storage)  
- Datenschutz gemäß **DSGVO** und **DHBW-Vorgaben**

---

### Hinweis zur Diagrammeinbindung
Jeder Anwendungsfall (Abschnitte 2.2 – 2.7) enthält Platzhalter für die UML-Diagramme (Aktivitäts-, Sequenz- oder Zustandsdiagramme).  
Die textuellen Beschreibungen erläutern bereits, **wie die Diagramme miteinander zusammenhängen** und den jeweiligen Use Case ergänzen.
