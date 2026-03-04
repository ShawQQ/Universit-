
Interruttore di luce da pulsante

Realizzare un sistema che sia in grado di accendere o spegnere una lampadina tramite un pulsate:
Input: 1 se pigiato, 0 se rilasciato
Output: C = comando: 1 collega la lampadina alla rete, 0 scollega

Il flusso del problema è rappresentabile dal seguente pseudocodice:

```
    ```pseudo
	   Finché P==0; //aspetta premuta pulsate
	   Se("lampada spenta") allora C=1; Altrimenti C=0
	   Finché P==1; //aspetta rilascio pulsante
	   vai a 1
    ```
```
Questa versione non va bene: cosa significa "Lampada spenta"?
Per risolvere questo problema, introduciamo una variabile locale S. La soluzione diventa quindi

Variabili interne: S = conserva l'ultimo valore di C
```
    ```pseudo
		S=C=0
		Finché P==0; //aspetta premuta pulsate
		Se(S==0) allora S=C=1; Altrimenti s=C=0
		Finché P==1; //aspetta rilascio pulsante
		vai a 1
    ```
```
La soluzione non è comunque corretta; infatti nel problema non viene mai specificato come dovrebbe funzionare il pulsante, e quindi introdurre i due cicli di wait in questa fase è un errore.