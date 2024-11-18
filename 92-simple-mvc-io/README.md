# mini MVC

La classe `Controller` deve implementare un semplice controller responsabile dell'accesso I/O.
Considera un singolo file alla volta ed è in grado di serializzare oggetti al suo interno.

Implementa questa classe con:

1. Un metodo per impostare un File come file corrente
2. Un metodo per ottenere il File corrente
3. Un metodo per ottenere il percorso (in forma di String) del `File` corrente
4. Un metodo che riceve una `String` come input e salva il suo contenuto nel file corrente.
Questo metodo può lanciare un'`IOException`.
5. Di default, il file corrente è "output.txt" all'interno della cartella home dell'utente.

Una stringa che rappresenta la cartella home dell'utente locale può essere ottenuta usando `System.getProperty("user.home")`.
Il simbolo di separazione (/ su *nix, \ su Windows) può essere ottenuto come String attraverso il metodo `System.getProperty("file.separator")`.
L'uso combinato di questi metodi porta a un software che funziona correttamente su ogni piattaforma.

Una volta completato il `Controller`, implementa la classe `SimpleGUI` in modo che:

1. Abbia un metodo main che avvia l'applicazione grafica
2. Nel suo costruttore, imposta l'intera vista
3. L'interfaccia grafica consiste in un `JTextArea` con un pulsante "Save" proprio sotto (vedi `src/test/resources/ex02.png` per il risultato atteso).
4. SUGGERIMENTO: Usa un `JPanel` con `BorderLayout`
5. Di default, se l'interfaccia grafica viene chiusa, il programma deve uscire (chiama `setDefaultCloseOperation`)
6. Il programma chiede al controller di salvare il file se il pulsante "Save" viene premuto.

Vedi `src/test/resources/ex02.png` per verificare l'aspetto atteso.

Infine, implementa la classe `SimpleGUIWithFileChooser` come segue:

1. Aggiungi un `JTextField` e un pulsante "Browse..." nella parte superiore dell'interfaccia grafica.
Suggerimento: usa un secondo `JPanel` con un secondo `BorderLayout`, metti il pannello nel North del pannello principale,
metti il campo di testo al centro del nuovo pannello e metti il pulsante alla fine della linea del nuovo pannello.
2. Il `JTextField` dovrebbe essere non modificabile. E dovrebbe mostrare il file selezionato corrente.
3. Alla pressione, il pulsante dovrebbe aprire un `JFileChooser`. Il programma dovrebbe usare il metodo `showSaveDialog()` per visualizzare il file chooser,
e se il risultato è uguale a `JFileChooser.APPROVE_OPTION`, il programma dovrebbe impostare come nuovo file nel `Controller` il file scelto.
Se viene restituito `CANCEL_OPTION`, allora il programma non dovrebbe fare nulla.
Altrimenti, dovrebbe essere mostrato un dialogo di messaggio che dice all'utente che si è verificato un errore (usa `JOptionPane.showMessageDialog()`).
4. Quando nel controller viene impostato un nuovo `File`, anche l'interfaccia grafica deve riflettere tale modifica.
Suggerimento: non forzare il controller ad aggiornare l'UI: in questo esempio l'UI sa quando deve essere aggiornata, quindi
cerca di mantenere le cose separate.

Vedi `src/test/resources/ex03.png` per verificare l'aspetto atteso.
