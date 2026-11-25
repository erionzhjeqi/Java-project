void main() {
    var portiInput = IO.readln("Porti: ");
    int porti = Integer.parseInt(portiInput.trim());


    if (porti < 0 || porti > 65535) {
        System.out.println("Porti nuk ekziston.");
        return;
    }


    var protInput = IO.readln("Protokolli (TCP/UDP): ");
    String protokolli = protInput.trim().toUpperCase();


    double rreziku = switch (porti) {
        case 22 -> 7.5;
        case 53 -> 3.5;
        case 80 -> 4.0;
        case 123 -> 3.0;
        case 443 -> 2.0;
        case 3389 -> 9.0;
        case 8080 -> 6.0;
        default -> 5.0;
    };


    boolean lejohet = false;


    if (protokolli.equals("TCP")) {
        if (porti == 80 || porti == 443) {
            lejohet = true;
        } else if (porti == 22 || porti == 8080) {
            var brendshemInput = IO.readln("Nga rrjeti i brendshëm? (po/jo) ");
            if (brendshemInput.trim().toLowerCase().equals("po")) {
                lejohet = true;
            }
        }
    } else if (protokolli.equals("UDP")) {
        if (porti == 53 || porti == 123) {
            lejohet = true;
        }
    } else {
        System.out.println("Protokoll i panjohur.");
    }


    String statusi = lejohet ? "LEJOHET" : "BLLOKOHET";


    System.out.println(protokolli + " " + porti + ": " + statusi);
    System.out.printf("Rreziku i portit: %.2f nga 10%n", rreziku);
}

