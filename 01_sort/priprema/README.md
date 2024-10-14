# Računari

Razni novi računari su stilgi u RC59 i ispostavilo se da nemaju svi iste konfiguracije.
Dosta je teško odabrati odgovarajuće računare za učionice a potom i planirati instalacije operativnih sistema.

Na svu sreću, imamo spisak svih računara sa njihovim konfiguracijama.
Neophodno je da se napiše program koji će sortirati te računare spram njihovih konfiguracija.

U nastavku je opisan sadržaj fajla kao i šta je tačno potrebno da se implementira u programu.

## Sadržaj fajla

U fajlu koji se nalazi u [res](./res/) direktorijumu se nalaze svi podaci o računarima koje je potrebno namestiti u računskom centru RC59.
Na samom početku fajla u prvom redu se nalazi broj $n$ koji koji predstavlja broj računara koji su opisani u datom fajlu.

Svaki računar je opisan u ... redova i raspored po redovima je sledeći:

1. Informacije o procesoru (naziv proizvođača, model, količina L1 keš memorije, broj jezgara i brzina jezgara i godina proizvodnje).
2. Informacije o disku (da li je HDD ili SSD, količina prostora kao i tip konektora, npr. SATA ili M.2).
3. Informacije o matičnoj ploči (proizvođač i godina proizvodnje).
4. Informacije o RAM memoriji (proizvođač, količina memorije, brzina memorije kao i njen tip i godina proizvodnje).
5. Tip kućišta, tj. da li je "regular", "small" ili "all-in-one".

U redovima gde se nalazi više od jedne informacije, te informacije su razdvojene razmacima.
Svaka od gore navedenih stavki kao prvi podatak u svom redu ima i evidencioni broj koji jedinstveno opisuje jednu komponentu.

## Izrada programa

Očekuje se da će program biti napisan tako da se podaci o jednom računaru skladište u jednoj klasi koja se zove `Racunar` dok ostali podaci se skladište u drugim klasama (`Procesor`, `Disk`, `MaticnaPloca`, `Memorija`, `Kuciste`).
Ti podaci koji opisuju jedan računar će se skladištiti kao polja unutar klase `Racunar`.

Na vama je da napišete funkciju za učitavanje `Racunar[] ucitaj(String filename)` koja će učitati podatke u jednom računaru i skladištiti ih u niz.
Učitavanje je završeno kada su svi računari učitani a smatra se da je fajl ispravno formatiran.
Ukoliko nije moguće učitati podatke iz fajla (fajl ne postoji ili nije dostupan za čitanje), program odmah prekida sa radom i ne treba ništa posle toga da se dogodi.

### `Comparable`

Svaka od gore navedenih klasa treba da implementira interfejs `Comparable` kako bi njihove instance mogle da se porede.
Njihov prirodni komparator treba da radi poređenje po svim stavkama koje opisuju jednu komponentu redom osim po evidencionom broju.
Sami računari se prirodno porede po svim stavkama redom kako je navedeno u opisu sadržaja fajla.

### `Comparator`

Potrebno je pored samog prirodnog komparatora ugrađenog u klase implementirati i dodatne komparatore koji porede klase na neke dodatne načine.

### Sortiranje

Prilikom implementacije komparatora, radi testiranja niz se može testirati ugrađenim metodom za testiranje `Arrays.sort()`.

Kada se to uradi, potrebno je implementirati i dve elementarne metode za sortiranje: insertion i selection sort.
Metode je potrebno implementirati kao zasebne klase sa statičkom metodom `sort()` koja prima niz i komparator.

### Ispisivanje

Neophodno je nakon što su računari sortirani da se implementira ispisivanje podataka u fajl u istom formatu kako su i učitani, tj. da je moguće da se izlazni fajl opet učita u program bez da dođe do greške.
