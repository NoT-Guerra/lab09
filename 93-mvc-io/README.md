# Model-View-Controller

Scrivi l'interfaccia `Controller`: deve modellare un semplice controller responsabile dell'accesso I/O.
Considera solo l'output standard ed è in grado di stampare su di esso.

Successivamente, implementalo in una classe in modo che includa:

1. Un metodo per impostare la prossima stringa da stampare. I valori nulli non sono
accettabili e deve essere generata un'eccezione.
2. Un metodo per ottenere la prossima stringa da stampare.
3. Un metodo per ottenere la cronologia delle stringhe stampate (sotto forma di `List` di `String`).
4. Un metodo che stampa la stringa corrente.
Se la stringa corrente non è impostata, dovrebbe essere generata un'eccezione `IllegalStateException`.

Una volta completato il `Controller`, implementa la classe `SimpleGUI` in modo che:

1. Abbia un metodo main che avvia l'applicazione grafica.
2. Nel suo costruttore, configuri l'intera vista.
3. L'interfaccia grafica consiste in un `JTextField` nella parte superiore del frame,
un `JTextArea` al centro e due pulsanti sotto di esso: "Print" e "Show history".
SUGGERIMENTO: Usa un `JPanel` con `BorderLayout`.
4. Per impostazione predefinita, se l'interfaccia grafica viene chiusa, il programma deve terminare (chiama `setDefaultCloseOperation`).
5. Il comportamento del programma è che, se si preme "Print", il controller 
deve mostrare la stringa contenuta nel campo di testo sull'output standard.
Se invece si preme "Show history", la GUI deve mostrare tutte le stampe 
effettuate fino a quel momento nell'area di testo.
