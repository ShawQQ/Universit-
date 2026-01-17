package Esame.Badge;

public class App {

    // DECOMMENTA IL MAIN PER ESEGUIRE IL TEST COMPLETO
    public static void main(String[] args) {
        System.out.println("=== TEST COMPLETO: Stabilimento / Badge / Ruolo / BadgeForbiddenException ===\n");

        System.out.println("1) Creo uno stabilimento valido (nome con almeno una parola MAIUSCOLA di 2 lettere).");
        Stabilimento s1 = null;
        try {
            s1 = new Stabilimento("AC TORINO");
            System.out.println("   OK: Stabilimento creato. ID=" + s1.getID() + " | nome=" + s1.getNomeStabilimento());
        } catch (Exception e) {
            System.out.println("   ERRORE: non doveva fallire. Eccezione: " + e);
        }

        System.out.println("\n2) Creo un secondo stabilimento valido.");
        Stabilimento s2 = null;
        try {
            s2 = new Stabilimento("MI MILANO");
            System.out.println("   OK: Stabilimento creato. ID=" + s2.getID() + " | nome=" + s2.getNomeStabilimento());
        } catch (Exception e) {
            System.out.println("   ERRORE: non doveva fallire. Eccezione: " + e);
        }

        System.out.println("\n3) Provo a creare uno stabilimento NON valido (nessuna parola MAIUSCOLA di 2 lettere).");
        try {
            Stabilimento sBad = new Stabilimento("Torino nord");
            System.out.println("   ERRORE: non doveva essere creato. ID=" + sBad.getID() + " | nome=" + sBad.getNomeStabilimento());
        } catch (Exception e) {
            System.out.println("   OK: fallito come previsto. Eccezione: " + e.getClass().getSimpleName() + (e.getMessage() != null ? " | msg=" + e.getMessage() : ""));
        }

        System.out.println("\n4) Creo 3 badge nello stabilimento 1, con ruoli diversi.");
        Badge b1 = null;
        Badge b2 = null;
        Badge b3 = null;
        try {
            b1 = s1.creaBadge("LU ROSSI", Ruolo.Operatore);
            System.out.println("   OK: Badge creato. ID=" + b1.getID() + " | nominativo=" + b1.getNominativo() +
                    " | stabilimentoID=" + b1.getStabilimentoID() + " | ruolo=" + b1.getRuolo() + " | attivo=" + b1.isAttivo());
        } catch (Exception e) {
            System.out.println("   ERRORE: non doveva fallire. Eccezione: " + e);
        }
        try {
            b2 = s1.creaBadge("MA BIANCHI", Ruolo.Caporeparto);
            System.out.println("   OK: Badge creato. ID=" + b2.getID() + " | nominativo=" + b2.getNominativo() +
                    " | stabilimentoID=" + b2.getStabilimentoID() + " | ruolo=" + b2.getRuolo() + " | attivo=" + b2.isAttivo());
        } catch (Exception e) {
            System.out.println("   ERRORE: non doveva fallire. Eccezione: " + e);
        }
        try {
            b3 = s1.creaBadge("GI VERDI", Ruolo.Dirigente);
            System.out.println("   OK: Badge creato. ID=" + b3.getID() + " | nominativo=" + b3.getNominativo() +
                    " | stabilimentoID=" + b3.getStabilimentoID() + " | ruolo=" + b3.getRuolo() + " | attivo=" + b3.isAttivo());
        } catch (Exception e) {
            System.out.println("   ERRORE: non doveva fallire. Eccezione: " + e);
        }

        System.out.println("\n5) Verifico che l'ID badge sia auto-generato e incrementale (senza passarlo al costruttore).");
        if (b1 != null && b2 != null && b3 != null) {
            System.out.println("   ID creati: b1=" + b1.getID() + ", b2=" + b2.getID() + ", b3=" + b3.getID());
            System.out.println("   Nota: qui mi aspetto che siano diversi e tipicamente incrementali.");
        } else {
            System.out.println("   IMPOSSIBILE verificare: almeno un badge è null per via di errori precedenti.");
        }

        System.out.println("\n6) Provo a creare un badge NON valido (nominativo non contiene almeno due parole MAIUSCOLE di 2 lettere).");
        try {
            Badge bBad = s1.creaBadge("Luca Rossi", Ruolo.Operatore);
            System.out.println("   ERRORE: non doveva essere creato. ID=" + bBad.getID() + " | nominativo=" + bBad.getNominativo());
        } catch (Exception e) {
            System.out.println("   OK: fallito come previsto. Eccezione: " + e.getClass().getSimpleName() + (e.getMessage() != null ? " | msg=" + e.getMessage() : ""));
        }

        System.out.println("\n7) Check diretto sul badge (metodo boolean check(long stabilimentoID)).");
        if (b1 != null && s1 != null && s2 != null) {
            System.out.println("   b1.check(s1.ID) => mi aspetto TRUE.");
            System.out.println("   Risultato: " + b1.check(s1.getID()) + " | attivo=" + b1.isAttivo());

            System.out.println("   b1.check(s2.ID) => mi aspetto FALSE (tentativo errato #1).");
            System.out.println("   Risultato: " + b1.check(s2.getID()) + " | attivo=" + b1.isAttivo());

            System.out.println("   b1.check(s2.ID) => mi aspetto FALSE (tentativo errato #2).");
            System.out.println("   Risultato: " + b1.check(s2.getID()) + " | attivo=" + b1.isAttivo());

            System.out.println("   b1.check(s2.ID) => mi aspetto FALSE (tentativo errato #3) e da ora attivo diventa FALSE.");
            System.out.println("   Risultato: " + b1.check(s2.getID()) + " | attivo=" + b1.isAttivo());

            System.out.println("   Ora il badge è disattivato: qualsiasi check deve tornare SEMPRE FALSE, anche con l'ID giusto.");
            System.out.println("   b1.check(s1.ID) => mi aspetto FALSE.");
            System.out.println("   Risultato: " + b1.check(s1.getID()) + " | attivo=" + b1.isAttivo());
        } else {
            System.out.println("   IMPOSSIBILE eseguire: b1/s1/s2 null.");
        }

        System.out.println("\n8) Test del check dello stabilimento: void check(Badge b) throws BadgeForbiddenException");
        if (s1 != null && s2 != null && b2 != null) {
            System.out.println("   Caso A: b2 appartiene a s1, quindi s1.check(b2) deve PASSARE (nessuna eccezione).");
            try {
                s1.check(b2);
                System.out.println("   OK: accesso consentito da s1 per b2.");
            } catch (BadgeForbiddenException e) {
                System.out.println("   ERRORE: non doveva lanciare eccezione. " + e.getClass().getSimpleName() + (e.getMessage() != null ? " | msg=" + e.getMessage() : ""));
            }

            System.out.println("\n   Caso B: provo s2.check(b2) => b2 non appartiene a s2, quindi deve lanciare BadgeForbiddenException.");
            try {
                s2.check(b2);
                System.out.println("   ERRORE: non doveva consentire accesso.");
            } catch (BadgeForbiddenException e) {
                System.out.println("   OK: eccezione lanciata come previsto: " + e.getClass().getSimpleName() + (e.getMessage() != null ? " | msg=" + e.getMessage() : ""));
            }

            System.out.println("\n   Caso C: faccio fallire b2 per 3 tentativi errati via s2.check(b2) e poi verifico che anche s1.check(b2) fallisca.");
            try {
                s2.check(b2);
            } catch (BadgeForbiddenException e) {
                System.out.println("   Tentativo errato #1 su s2 per b2 => eccezione OK. attivo=" + b2.isAttivo());
            }
            try {
                s2.check(b2);
            } catch (BadgeForbiddenException e) {
                System.out.println("   Tentativo errato #2 su s2 per b2 => eccezione OK. attivo=" + b2.isAttivo());
            }
            try {
                s2.check(b2);
            } catch (BadgeForbiddenException e) {
                System.out.println("   Tentativo errato #3 su s2 per b2 => eccezione OK. attivo=" + b2.isAttivo());
            }

            System.out.println("   Ora b2 dovrebbe essere disattivato. Provo s1.check(b2): deve lanciare eccezione anche se era lo stabilimento giusto.");
            try {
                s1.check(b2);
                System.out.println("   ERRORE: non doveva consentire accesso.");
            } catch (BadgeForbiddenException e) {
                System.out.println("   OK: eccezione lanciata come previsto (badge disattivato). attivo=" + b2.isAttivo());
            }
        } else {
            System.out.println("   IMPOSSIBILE eseguire: s1/s2/b2 null.");
        }

        System.out.println("\n9) Verifico che un badge appena creato parta SEMPRE attivo.");
        if (s1 != null) {
            try {
                Badge bFresh = s1.creaBadge("PA NERI", Ruolo.Operatore);
                System.out.println("   Badge nuovo: ID=" + bFresh.getID() + " | attivo=" + bFresh.isAttivo() + " (mi aspetto TRUE)");
            } catch (Exception e) {
                System.out.println("   ERRORE: non doveva fallire. Eccezione: " + e);
            }
        }

        System.out.println("\n=== FINE TEST ===");
    }
}
