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
        case 443 -> 2.0;
        case 3389 -> 9.0;
        default -> 5.0;
    };

    boolean lejohet = false;
    boolean protokollIValid = true;

    if (protokolli.equals("TCP")) {
        if (porti == 80 || porti == 443) {
            lejohet = true;
        } else if (porti == 22) {
            var brendshemInput = IO.readln("Nga rrjeti i brendshëm? (po/jo) ");
            String pergjigje = brendshemInput.trim().toLowerCase();
            if (pergjigje.equals("po")) {
                lejohet = true;
            }
        }
    } else if (protokolli.equals("UDP")) {
        if (porti == 53) {
            lejohet = true;
        }
    } else {
        protokollIValid = false;
        System.out.println("Protokoll i panjohur.");
    }

    // Operator ternar për statusin
    String statusi = lejohet ? "LEJOHET" : "BLLOKOHET";

    // Printimi i rezultatit dhe rrezikut me printf
    System.out.println(protokolli + " " + porti + ": " + statusi);
    System.out.printf("Rreziku i portit: %.2f nga 10%n", rreziku);
}

