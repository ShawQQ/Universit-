
* Generare le seguenti classi Java:
* 1. Classe Astratta "Pagamento" con attributo "importo" (double).
* (l'importo deve essere maggiore o uguale a 0.01)
* 2. Classe "PagamentoBonifico" che estende "Pagamento" e aggiunge attributi "IBAN" (String) e "istantaneo" (booleano).
* (l'iban segue lo standard italiano: IT seguito da 2 numeri, 1 lettera e 22 numeri)
* (es. IT60X0542811101000000123456)
* 3. Classe PagamentoPaypal che estende Pagamento e aggiunge attributo "email" (String) e commissione (double).
* (la mail deve essere valida (quindi x@y.z, non usate le regex!) e la commissione deve essere maggiore o uguale a 0)
* (se la commissione è maggiore dell'importo, diventa uguale all'importo)
* 4. Classe PagamentoContanti che estende Pagamento senza attributi aggiuntivi.
*
* Ciascuno implementa un metodo "daiImporto()" che restituisce l'importo totale da pagare, considerando eventuali commissioni.
* Un bonifico ha una commissione del 10% se non è istantaneo, un pagamento PayPal ha una commissione inserita nell'attributo "commissione", mentre un pagamento in contanti non ha commissioni.
* Un pagamento in contanti non ha commissioni, e se i centesimi sono minori di 50, l'importo viene arrotondato per difetto all'euro più vicino.
*
* 5. Infine, crea una classe CassaPerPagamenti con due metodi:
*    - aggiungiPagamento(Pagamento p) per aggiungere un pagamento alla cassa. Lancia una eccezione se pagamento è null.
- calcolaTotale() che restituisce la somma di tutti gli importi pagati
       