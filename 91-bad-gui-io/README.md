# GUI monolitica semplice

## Capire
1. Leggi attentamente la classe
2. Leggi attentamente i commenti
3. Nota come ``System.getProperties()`` viene utilizzato per ottenere le proprietà del sistema corrente
4. Nota come queste proprietà sono utilizzate per produrre codice multipiattaforma
   **NOTA**: "scrivi una volta, esegui ovunque" è vero solo se il codice è progettato per essere multipiattaforma!
5. Nota l'uso di ``Toolkit`` per ottenere la risoluzione corrente dello schermo e dimensionare correttamente la finestra
6. Nota l'uso di ``JFrame.setLocationByPlatform()`` per delegare il posizionamento della finestra al compositore del sistema (la parte dello stack grafico che si occupa di disegnare effettivamente finestre, bordi, decorazioni ed effetti).

## Fare
### Es 01.01
1. Crea un nuovo JPanel
2. Usa un BoxLayout orizzontale come layout
3. Imposta il nuovo JPanel come unico contenuto del centro del BorderLayout corrente
4. Aggiungi il JButton "scrivi" al nuovo pannello
5. Testa la tua applicazione: dovrebbe apparire simile, ma il pulsante sarà più piccolo
6. In ``display()``, usa JFrame.pack() per ridimensionare il frame alla dimensione minima prima di visualizzare

### Es 01.02
1. Crea un nuovo pulsante "Leggi"
2. Aggiungilo al JPanel creato in ``Es 01.01``
3. Testa la tua applicazione. Verifica che puoi vedere un nuovo pulsante, ma è inutile
4. Scrivi un nuovo ``ActionListener`` per il nuovo pulsante, sotto forma di classe anonima, che stampa una stringa sul terminale (usa ``System.out``) quando il pulsante viene premuto.
5. Testalo

### Es 01.03
1. Modifica l'ActionListener in modo che legga il contenuto dello stesso file che viene scritto quando il pulsante "scrivi" viene premuto e stampi il suo contenuto sull'output standard

**Ricorda che:**
* Ci sono alcuni metodi _molto utili_ in `java.nio.Files` (ad esempio `[readAllLines](http://docs.oracle.com/javase/7/docs/api/java/nio/file/Files.html#readAllLines(java.nio.file.Path,%20java.nio.charset.Charset))`
* I `PrintStream` sono probabilmente il modo più semplice per scrivere testo nei file
