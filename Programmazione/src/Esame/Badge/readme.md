Genera la classe Badge e Stabilimento Ogni Badge ha almeno le seguenti proprietà, create alla costruzione e restituite da getters 
- long ID 
- String nominativo 
- long stabilimentoID 
- Ruolo ruolo 
- boolean attivo 
(nominativo deve contenere almeno due parole maiuscole di 2 lettere ciascuna. solo caratteri A-Z e spazio consentiti) 
(Ruolo è un enum con le seguenti voci Operatore, Caporeparto, Dirigente) 
(all'inizio è sempre attivo, e l'ID non viene passato, ma ottenuto da un counter statico privato incrementale) 
Creare inoltre i seguenti metodi: 
- boolean check(long stabilimentoID) 
(se l'id dello stabilimento corrisponde, torni true, altrimenti torna false) 
(dopo 3 tentativi attivo diventa false, e questo metodo tornerà sempre false a prescindere) 

Stabilimento ha le seguenti proprietà create alla costruzione 
- long ID 
- String nomeStabilimento 
(nomeStabilimento deve contenere almeno una parola di 2 lettere. solo caratteri A-Z e spazio consentiti) 
(id anch'esso passato da un counter statico privato personale di Stabilimento) 
Crea inoltre i seguenti metodi 
- Badge creaBadge(String nominativo, Ruolo ruolo) 
- void check(Badge b) throws BadgeForbiddenException 
(lancia l'eccezione sse il check di badge torna false) 
Crea anche la classe BadgeForbiddenException extends Exception con due costruttori. 
uno senza messaggio di errore, e uno con.