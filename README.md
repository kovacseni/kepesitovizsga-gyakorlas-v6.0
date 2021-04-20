# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd!
Bármely régebbi osztályt megnyithatsz.

Új repository-ba dolgozz! A `pom.xml` tartalmát nyugodtan át lehet másolni.
Projekt, könyvtár, repository neve legyen: `kepesitovizsga-gyakorlas-v6.0`.
GroupId: `training`, artifactId: `kepesitovizsga-gyakorlas-v6.0`. Csomagnév: `hu.nive.ujratervezes.kepesitovizsga`.

A feladatok megoldásához ajánlom figyelmedbe a cheat sheetet:

https://github.com/Training360/strukturavalto-java-public/blob/master/cheet-sheet/cheet-sheet.md

Először másold át magadhoz a teszteseteket, majd commitolj azonnal!

A három (de ötnek számító) feladatra 3 órád van összesen!

Oldd meg a feladatokat, minden feladat megoldását egy külön commitban
add be!
Ha letelik az idő az első commitodhoz képest és nem fejezted be, megint commitolj, akkor is,
ha nem vagy kész! Utána nyugodtan folytathatod a megoldást, akár több órát is
ülhetsz felette, ha kész vagy, commitolj!

## Matekfeladat

A Digits osztályba írj egy metódust, amely a következő matematikai feladat megoldását adja vissza:
Hány olyan kétjegyű pozitív egész szám van, amelyben az egyik számjegy 5-tel nagyobb a másiknál?

## Állatkert

Egy állatkertben a náluk gondozott állatokról (ZooAnimal) adatbázist vezetnek. Minden állatnak van neve, valamint
nyilvántartanak egy hosszúság adatot, amely csak néhány állatnál fontos (azoknál, amelyeknek valamely testrészük hosszú :) )
és egy súlyadatot, amely csak az igazán nehéz állatoknál érdekes:
- az oroszlánok (Lion) az állatkertbe kerülésükkor csak egy nevet kapnak, a többi tulajdonságuk elhanyagolható.
- a zsiráfok (Giraffe) esetében viszont már nyilvántartják a nyakuk hosszúságát is (a súlyuk nekik is elhanyagolható).
- az elefántoknál (Elephant) pedig a hosszúság értelemszerűen az ormány hosszát jelenti, illetve az előzőeken túl már fontos a súlyuk is.

A Zoo osztály reprezentálja az állatkertet. Ebben egy adatszerkezetben tárolják az állatokat, lekérdezhető formában. Az osztály
konstruktorban kapja meg az adatbázis eléréséhez szükséges adatokat. A következő metódusokat kell megvalósítani:
- `getAnimals()` : ezen a metóduson keresztül érhetjük el az adatszerkezetet.
- `loadAnimals()` : betölti az adatbázisból az állatok adatait az osztályba.
- `addAnimal(ZooAnimal animal)` : ezzel a metódussal lehet egy új állatot feltölteni az adatbázisba.
- `getHeaviestAnimalInTheZoo()` : visszaadja az állatkert legnehezebb állatát.
- `countWeights()` : összeszámolja, hogy mennyit nyomnak az állatkert állatai együttesen.
- `findExactAnimal(ZooAnimal animal)` : megkeresi a paraméterként megadott állatot (amennyiben az létezik).
- `findExactAnimalByName(String name)` : megkeresi a paraméterként megadott névvel rendelkező állatot (amennyiben az létezik).
- `getNumberOfAnimals()` : visszaadja, hogy hány állat található jelenleg az állatkertben.
- `getAnimalsOrderedByName()` : visszaad egy másik adatszerkezetet, amelyben ABC-sorrendben található az állatok neve.
- `getAnimalStatistics()` : visszaad egy másik adatszerkezetet, amelyből kiolvasható, hogy milyen fajta állatból mennyi van az állatkertben.

## Szép hosszú szavak

Adott egy szó, amely a következőhöz hasonló formában van megadva:
```
EXAM
XAMP
AMPL
MPLE
```
A feladat az, hogy a FineLongWord osztályban egy tömbben add vissza a szó betűit a megfelelő sorrendben.
Mivel a Java nyelv beépített osztálykönyvtára erre rendkívül tág lehetőségeket biztosít, ezért kapásból három
különböző, számodra már régóta ismerős szép hosszú szóval is tesztelheted a metódusodat. :)