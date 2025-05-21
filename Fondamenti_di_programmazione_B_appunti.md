# Fondamenti di programmazione B

## OOP - Programmazione Orientata agli Oggetti

### Concetto di astrazione

Diamo ad un oggetto un set definito (e finito) di proprietà

### Differenza con struct / liste

Per utilizzare le liste, devo conoscere la struttura e l'implementazione delle liste. Uno degli obiettivi della OOP è di nascondere la struttura del nostro oggetto ma poter comunque permettere all'esterno di utilizzare tutte le sue funzionalità.

### Interattività con gli oggetti

- **Metodi**: sono funzioni / azioni che si possono applicare all'oggetto
- Possono anche modificare e/o manipolare lo stato di un oggetto
- Tutte le istanze di uno specifico oggetto condivideranno le stesse proprietà e metodi


### Classe

Una classe è un insieme di oggetti che condividono una struttura e un comportamento. Contiene la specifica dei dati che descrivono un oggetto che ne fa parte.

Ogni classe è costituita da:

- **Proprietà**: attributi di una particolare classe (velocità, targa, benzina, ...)
- **Metodi**: (aggiungiBenzina, accelera, frena, ...)


### Problema di inizializzazione

Quando si definisce un oggetto, i valori dei suoi attributi non sono definiti → possono avere qualunque valore. Vorremmo avere un metodo che inizializzasse i campi del nostro oggetto → costruttore.

### Public and Private (visibilità)

C'è la necessità di mantenere alcuni metodi / attributi privati, perché fanno parte dell'implementazione di un oggetto e/o non vogliamo che l'utente ci acceda in modo diretto.

La parte public contiene i metodi che l'utente può invocare per modificare l'oggetto (= è l'interfaccia pubblica della classe).

- La parte public è esposta all'esterno
- La parte public interagisce con la parte private


### Incapsulamento

Permette di racchiudere il codice che definisce un oggetto in una parte specifica del codice (unità), evitando di avere metodi sparsi per un intero file di codice.

### Information hiding

Meccanismo per nascondere alcuni componenti / comportamenti di una classe.
Obiettivo: nascondere l'implementazione del nostro oggetto.
Espongo esclusivamente l'interfaccia con cui gli utenti possono interagire.

### Altre proprietà della OOP

- Parametrizzazione dei tipi
- Ereditarietà


## Tipi di dato astratto

La struttura del tipo di dato (e la sua implementazione) è nascosta.
Noi ci occupiamo solo di come utilizzarlo (operazioni e valori possibili).

### Esempio con le struct

Per manipolare una particolare struct, devo conoscere nello specifico la sua implementazione = è un tipo di dato, ma non astratto.
L'accesso ai dettagli implementativi non è controllato → l'utente può accedere in modo diretto ai campi delle struct.
Obiettivo: nascondere l'implementazione e fornire solo l'interfaccia pubblica all'utente.

### OOP: costrutti fondamentali

OOP fornisce diversi costrutti che garantiscono:

- Incapsulamento
- Information hiding
- Ereditarietà → derivare nuovi tipi da tipi già definiti
- Parametrizzazione dei tipi → definizione di nuovi tipi in modo parametrico (es. creazione di liste di tipo T [data type generico])


### This - campo implicito

È un puntatore all'oggetto di invocazione:

- "this" punta all'oggetto su cui è invocato il metodo
- Per accedere ai campi con "this" si usa l'operatore "→"


### Attributi e metodi

- **Attributi**: rappresentano lo stato di un oggetto
- **Metodi**: rappresentano le azioni applicabili ad un oggetto


### Classi statiche

In C++ e Java, le classi sono statiche, cioè non è possibile modificare la struttura di una classe (aggiungendo attributi / metodi) a runtime.

### Costruttore - introduzione

Metodo con una firma particolare utilizzato per inizializzare i valori degli attributi di una specifica classe.
Una volta che viene definito un oggetto nel main, il costruttore viene chiamato di default.

## Costruttori

Problema: in C++ un oggetto viene creato di default con valori iniziali dei campi non specificati.
Non possiamo rendere i campi public, dato che non garantirebbe l'information hiding.

Soluzione = Costruttore di una classe:

- È un metodo public
- Ha lo stesso nome della classe
- Può avere 0 parametri
- Non ha tipo di ritorno

NB: possono essere sia public che private

### Sintassi

```cpp
Oggetto o1(<param1>, <param2>) // Oggetto o1 = {<param1>, <param2>}... Nello stack
```

Nello stack viene allocata una parte di memoria sufficiente per contenere un oggetto (es. Razionale) con valori "random".
Automaticamente viene invocato il costruttore senza parametri, che inizializza i campi dell'oggetto con un valore specifico → li decidiamo noi.

### Più costruttori

È possibile avere più costruttori, specificando anche dei parametri.

### Costruttore di default

Se non viene definito alcun costruttore, C++ ne fornisce uno automaticamente del tipo:

```cpp
Oggetto (){}
```

Nel momento in cui si aggiunge un costruttore che richiede almeno 1 parametro, quello vuoto (di default) non è più disponibile.

### Delega (delegating construct)

È possibile definire un costruttore utilizzando la chiamata ad altri costruttori.
La modalità di esecuzione è analoga a quella che avviene nello stack di chiamata (FILO).

Tale concetto è legato all'utilizzo dell'astrazione.

#### Sintassi

```cpp
Oggetto() : Oggetto(<param1>) { // codice }
```

Il codice verrà eseguito dopo che avvenuta la delega al costruttore con un parametro.

### Allocazione

Tutti gli oggetti in C++ è possibile allocare gli oggetti sia nello Heap che nello Stack.
In Java, tutti gli oggetti vengono allocati nello Heap.

Per allocare nello Heap:

```cpp
Oggetto* o; // o è allocato nello Stack
o = new Oggetto(<param1>, <param2>) // o punta ad un oggetto Oggetto allocato nello Heap
```

Per accedere ai metodi, si dovrà usare la notation con "→" (oppure deferenziare il pointer e successivamente accedere con la dot annotation).

### o1 = o2

Viene effettuata una copia campo-a-campo → shell copy (copia leggera).
Se ci sono campi che sono pointer, un determinato campo o1 verrà sovrascritto, puntando alla stessa zona di memoria o2.
Problema riguardo una zona non deallocata (la quale era puntata da o1) e che non è puntata da alcun puntatore.

Obiettivo → effettuare una deep copy, riscrivendo il metodo in cui l'operatore "=" opera con gli oggetti.

### Esempio

```cpp
Razionale* r1 = new Razionale(1, 2); // r1 punta ad un oggetto Razionale
Razionale* r2 = r1; // r2 punta allo stesso oggetto puntato da r1
*r1 = Razionale(3, 4); // si effettua una copia campo a campo di ciò a cui punta r1, creando un nuovo oggetto Razionale (esso risiede nello stack, non vi è alcun "new")
```


### Metodi di classe

Sono metodi forniti all'intera classe e non ad una singola istanza (oggetto) di una classe.

#### Sintassi

```cpp
Oggetto :: metodo(...){...}
```


## Attributo "this"

- Attributo implicito presente in ogni classe
- È un puntatore a elementi della classe
- Viene inizializzata automaticamente quando viene invocato il costruttore, in modo che punti all'oggetto appena creato
- Essendo un puntatore, si utilizza utilizzando l'operatore "→" (NO dot notation)
- È private e const → non si può modificare il suo valore (solo lettura)

Scopo: utilizzato per riferirsi all'oggetto di invocazione di un metodo.

### Metodi di una classe VS funzioni

I metodi di una classe sono funzioni, in cui vi è un parametro implicito sempre presente, ossia this → un puntatore all'oggetto chiamante del metodo.

## Overloading di funzioni

Possibilità di definire più funzioni con lo stesso nome, che si distinguono per tipo e/o numero di parametri.
Devono avere lo stesso tipo di ritorno.

## Overloading degli operatori

Esempio → Operatore + è overloaded:

- Esegue somma tra int
- Esegue somma tra float

Obiettivo → vorrei implementare la possibilità di utilizzare l'operatore + tra due oggetti (es. due Razionali).

Se si vuole sovraccaricare un operatore op è necessario definire il metodo: `operator<op>`

Overloading operatore somma: `<C> operator+ (...){...}`

### Overloading operator+ - Razionale

L'ordine dei parametri è più importante → r1 + r2 != r2 + r1.
La sintassi r1.operator+(r2) è valida.

### operator++ - operatore prefisso

`*this = *this + 1` → è uguale a `this->operator+(1)`

### operator++ - operatore postfisso

Firma del metodo: `<object> operator++(int)` → non viene comunque richiesto un parametro aggiuntivo, è solo per differenziare con la signature del prefisso.
NB: *this viene incrementato, ma deve essere ritornato l'oggetto *this escludendo l'incremento.

## Reference return

È possibile ritornare il riferimento a determinati attributi di una classe.

Esempio (Razionale):
`r7 = 5;` → se sovrascrivo l'operatore [] in modo che ritorn il valore del num di r7, non compila in quanto non posso assegnare un int ad un int.
Dovrei ritornare la zona di memoria del denominatore dell'oggetto di invocazione per riferimento (in modo che venga effettivamente modificato).

## Input / output

cin e cout sono sottoclassi di istream e ostream:

- istream → stream generico di input
- ostream → stream generico di output

`void read(istream& in)` permette di avere un metodo generico ed unico per poter leggere da qualsiasi standard di input (file, standard output, …).
Passaggio per riferimento → non ha senso fare una copia per cin / cout per ogni volta che chiamo i metodi, quindi eseguo un passaggio per riferimento.

### Overloading operatori input / output

```cpp
void operator<<(ostream& dest){...}
```

Nel main non possiamo chiamarli come da standard, ma in questo modo:

```cpp
r1 << cout;
```

oppure

```cpp
r1.operator<<(cout);
```

Questo avviene perchè si suppone che il primo parametro sia l'oggetto di invocazione.

Per leggere e stampare come da standard (cout << r1), devo eseguire l'overloading all'esterno della classe.

### Metodi esterni - regola generale

Quando definiamo un metodo all'interno di una classe, è implicito che il primo parametro sia l'oggetto chiamante del metodo (*this).

Pro: Per gestire e controllare l'ordine dei parametri, devo definire delle funzioni esterne alla classe (in questo modo, specifico i parametri nell'ordine che voglio).
Contro: non garantiamo più l'incapsulamento.

### Metodi costanti

Obiettivo: rendere l'oggetto che invoca uno specifico metodo (ossia *this - "ciò a cui punta this") costante, in modo che non venga modificato.

Esempio:

```cpp
void write(ostream& dest) const {...}
```


### Input / output in sequenza

Per stampare / leggere in output / input più Razionali, devo returnare lo stream di output / input nell'overloading dei rispettivi operatori.
Una volta eseguita la print / read, restituisco lo stream, in modo che venga returnato lo stream con il side - effect di aver stampato / letto da standard output / input.

## Passaggio di parametri per constant reference

Abbiamo già visto come passare dei parametri in modo const, in modo che una funzione non possa modificare il loro valore.
Se un parametro è passato in modo const, qualunque funzione non può produrre side-effect su tale parametro.

NB: il passaggio per constant reference garantisce che l'oggetto sia costante (e quindi i suoi attributi), ma se un attributo è un puntatore a qualcos altro (es. array), esso può essere modificato.

## Metodi getter e setter

Metodi getter si occupano di:

- Ritornare le proprietà della classe

Metodi setter si occupano di:

- Permettere di settare degli specifici valori agli attributi

Sono:

- Public
- Getter sono costanti, tipo di ritorno è il tipo dell'attributo specifico
- Setter non sono costanti, tipo di ritorno è void


## Stringhe

Implementazione di stringhe = char di caratteri con un delimitatore finale (\0).
Non è un tipo di dato astratto → è necessario conoscere la loro implementazione per manipolarle.
Obiettivo = creare un tipo di dato astratto stringa per utilizzarle senza conoscere la loro implementazione.

### Classe string

È un tipo di dato astratto, quindi garantisce:

- Incapsulamento
- Information hiding

Possibile implementazione:

- int l; → lunghezza della stringa
- char* s; → struttura dati per la stringa (es. array dinamico)


#### Inizializzazione

```cpp
string s; // viene invocato il costruttore senza parametri, la stringa è inizializzata a stringa vuota

string t = "hello"; // viene invocato il costruttore con un parametro, passando per parametro un const char pointer (stessa implementazione di Programmazione A):
// Inizializzata la lunghezza (con strlen)
// inizializzazione di t ad un array dinamico di lunghezza len
```


### Costruttore di copia

Si occupa di creare una copia, prendendo come parametro un oggetto dello stesso tipo di quello in cui si vuole copiare.
Tutte le classi lo hanno.
Il suo comportamento di default è copiare campo per campo.
È necessario sovrascrivere il suo comportamento per l'implementazione della classe string → dobbiamo creare un nuovo char pointer per copiare carattere per carattere, altrimenti si creerebbero alias.

Il passaggio per parametro, per gli oggetti, è realizzato mediante il costruttore di copia.

### .size method

Calcola la lunghezza di una stringa.
Metodo costante → non modifica né len ne *this.

### Overloading operator= (con parametro string)

Non è possibile utilizzare il costruttore di copia, perchè:

- Il costruttore di copia viene invocato su un oggetto non ancora inizializzato
- L'operator = accetta un oggetto che è gia inizializzato, e sovrascrive i suoi valori

L'operator = inoltre ha il compito di deallocare la zona di memoria puntata da s (array di caratteri) e di crearne uno nuovo, copiando i valori del right side.

L'operator = ritorna per riferimento ad una stringa (*this) per lo stesso motivo dell'overloading dell'operator<< e >>.

### Overloading operator= (con parametro const char[])

Permette di copiare una stringa implementata come const char pointer dentro una stringa implementata mediante classe string.

### Operatori di confronto

Sono metodi costanti.

### Overloading operator[]

Tipo di ritorno = reference ad un char(char\&), in quanto in fase di assegnamento (s = …) dobbiamo assegnare una zona di memoria ad un valore, e non un char ad un char stesso.

### Overloading operator << e >> (scrittura e lettura)

Analoga all'overloading delle scorse classi.
Vanno al di fuori della classe string.

### getline

Il getline di cin (in generale di qualunque stream) legge un array di caratteri.
Il getline per le stringhe è una funzione esterna alla classe, prende come parametri:

- Lo stream
- la stringa (di tipo string)
- Carattere terminatore (analogo al getline "classico")


### Passaggio

Per passare da un array di caratteri ad una stringa è possibile utilizzare un costruttore di copia.
Per passare da una stringa ad un array di caratteri di utilizza un metodo: c_str().

## Classe StringSet

Implementazione della classe StringSet:

- l → indica quanti elementi ci sono nell'array e indica la prossima cella della stringa in cui andare a scrivere


## Gestione delle eccezioni

Mediante:

- throw → statement
- classe (es. invalid_argument("..."))

esempio → "throw invalid_argument("invalid argument!")"

## Funzione rand()

Ritorna un numero pseudo-casuale tra 0 e (circa) 32 mila.

Per generare un numero compreso tra dei limiti, si utilizza l'operatore %.

Perchè pseudo-casuale e non causale?

- I numeri casuali non esistono
- Per generare numeri randomici, si parte da un seed (ossia un punto di partenza) → ad ogni esecuzione, cambiando il seed si avranno numeri pseudo-causali
- Possibile seed = tempo

Per settare il seed in base al tempo → `srand(time(0))`

Se si memorizza il numero di volte in cui ogni numero è uscito all'interno di un array, è possibile visualizzare che il numero di volte in cui un numero è uscito è abbastanza distribuito (probabilità di 1 / 6).

### Lancio truccato

Inseriamo una condizione per cui vengono estratti numeri dall'1 all'8.
In caso esca un numero al di fuori delle facce del dado (da 1 a 6), estraiamo il numero 5 → maggiore probabilità che esca il numero 5.

## Gestione delle eccezioni

Si possono manifestare delle situazioni anomale / di errore che deviano dalla normale esecuzione del programma (possono anche non essere colpa del programmatore).
Le eccezioni possono essere di tipo:

- errori di sistema operativo
- indisponibilità di risorse
- errori nascosti / comportamenti inattesi

È possibile rilevare le eccezioni e gestirle opportunamente.
esempio di gestione: interruzione di esecuzione, attivazione di alcune procedure.
Dobbiamo lasciare la gestione dell'errore all'utente, non forzandola (es. settando un valore di default scelto da noi).

### Possibile soluzione (utilizzo metodi bool)

Utilizzo di metodi con tipo di ritorno bool (es. metodo leggi).
Non utilizzabile, errata perché:

- Non adottabile per costruttori
- Annidamento di chiamate → non posso gestire singoli errori diversi in tutte le chiamate
- Il tipo di ritorno non può essere utilizzato per segnalare qualcosa all'utente (concettualmente sbagliato)


### Eccezioni

Il lancio di un'eccezione indica una situazione anomala che non dovrebbe verificarsi nella normale esecuzione del programma.
Quando ciò accade, il chiamante può decidere di fare un'azione "riparatrice".
Se non la gestisce, il programma continua e potrebbe terminare con uno stato d'eccezione (no return 0).

### try, catch, throw

- try → blocco di codice che potrebbe rilevare le eccezioni. Si prova ad eseguire il programma e, se viene lanciata una eccezione, si può decidere di catturarla con catch.
- catch → cattura (e gestisce) le eccezioni del blocco try. È qui che andremo a mettere l'azione riparatrice per ripristinare la normale esecuzione del programma. Se il catch è di tipo int e viene sollevata un'eccezione di tipo string, il blocco catch non catturerà l'eccezione (il catch, in questo esempio, cattura solo eccezioni di tipo int). È possibile inserire più blocchi catch per diversi tipi di throw, per matchare il tipo.
- throw → solleva un'eccezione

Una volta sollevata l'eccezione ed eventualmente catturata, l'esecuzione NON prosegue dalla funzione che ha generato l'eccezione.

### Definizione di throw

Sintassi:

```cpp
throw e
```

e → espressione di tipo t

- Salta al primo blocco catch con parametro di tipo t che si incontra lungo la catena dinamica delle chiamate a funzione
- Tutti gli stack tra il throw e il try vengono deallocati
- Si esegue il blocco catch
- Riprende la normale esecuzione


### Definizione try - catch

Sintassi:

```cpp
try {
    stmts
} catch (t0, x0) {
    stmts0
} catch (t1, x1) {
    stmts1
}
```

Osservazioni:

- I metodi si limitano a sollevare le eccezioni
- La gestione delle eccezioni è gestita dai chiamanti (fuori dalla classe)
- La chiamata di funzione che lancia l'eccezione non è necessariamente contenuta nel blocco try - catch

Esempio dell'ordine:
→ main esegue lettura →
→ operator>> chiama metodo leggi() →
→ metodo leggi solleva eccezione (throw)
→ vengono deallocati stack di leggi e operator>>, prima di passare al main

### catch(...)

Può essere visto come il ramo default dello switch.
In caso non venga matchata l'eccezione con nessun blocco catch, cattura tutto quello che non è stato catturato nei blocchi catch precedenti.
Deve essere l'ultimo blocco catch.

### Eccezioni standard

Esiste una standard library per le eccezioni:

```cpp
#include<exception>
```

Può essere usata come classe base per creare nuove eccezioni.

Esempio di eccezioni standard:

- out_of_range
- invalid_argument

Sono delle sottoclassi della classe base exception (eccezione generale).

## Implementazione Stack (Lista)

### Attributi

- Un array dinamico di elementi → int* a;
- top → posizione dell'ultimo elemento aggiunto (NB: parte da 0 come gli array)
- cap → dimensione della lista


### Metodi

- push() → inserisce un elemento in testa allo Stack
- pop() → estrae l'ultimo elemento inserito nello Stack (LIFO). Ritorna l'elemento in cima alla lista + lo rimuove dalla lista (top- -)
- enlarge() → aumenta la dimensione dell'array dinamico, in modo che possa ospitare più elementi
- ~Stack() → Distruttore, dealloca l'array dinamico (delete [] a)


## Layout della memoria

- Stack → allocazione automatica, riguarda l'allocazione dei dati locali. La gestione della memoria è automatica, una volta usciti dal blocco (fuori dal suo scope) viene deallocata. Tempo di vita = tempo di esecuzione del blocco, corrisponde con il suo scoping.
- Heap → allocazione dinamica
- Data segment → allocazione statica, sono presenti variabili statiche e globali

Tempo di vita di una variabile → tempo che percorre tra la sua creazione e la sua deallocazione.

### Gestione della memoria - Stack

Alla chiamata di ogni funzione il controllo passa a quella funzione.
Viene pushata in top la funzione.
Una volta terminata, il blocco di quella funzione viene distrutto.
Per questo il valore delle funzioni viene ritornato per valore → se ritornassimo per reference, una volta distrutto quel blocco quella variabile non esisterebbe più.

## Distruttore

Ha il compito di deallocare la memoria allocata da un oggetto.

### Caratteristiche

- È un metodo public
- È unico e sempre presente in una classe (implicito o esplicito)
- Nel momento in cui lo definiamo, quello di default non viene più utilizzato
- Ha lo stesso nome della classe + ~
- È senza parametri
- Non ha return type

Il corpo del distruttore non si occupa di distruggere l'oggetto, bensì di compiere alcune operazioni prima di distruggerlo.
Dopo aver eseguito il codice del distruttore, esso richiama un distruttore per ogni suo field.

### Quando è necessario ridefinire il distruttore

Quando dobbiamo gestire della memoria dinamica: in quel caso, il distruttore dovrà rimuovere la memoria allocata nello heap prima di rimuovere l'oggetto vero e proprio.

## Overloading operatore di assegnamento

Operazione di default → copia campo a campo degli attributi del right side dentro il left side.

Tipo di ritorno → constant reference return:

- Return *this
- Viene ritornato per constant, in modo da non avere sight effect su this. Ad esempio. non potrò fare (r1 = r2)++
- Infatti, l'oggetto ritornato è const ("in quel momento") e può essere acceduto solo in lettura


### Quando è necessario sovraccaricare l'operatore di assegnamento?

Quando sono presenti puntatori a zone di memoria: in quel caso, non vogliamo copiare gli indirizzi di memoria (NO memoria condivisa, side effect).
Qualsiasi modifica faccia a quella zona di memoria, sarà propagata anche all'altro oggetto.

## Memoria dinamica - riassunto

Se si hanno classi che gestiscono memoria dinamica e puntatori, è OBBLIGATORIO definire:

- Distruttore
- Costruttore di copia
- Overloading operatore di assegnamento


## Costruttore di copia

- È public
- Fa parte dei costruttori
- Unico parametro di tipo constant reference

Non è possibile richiamare l'overloading dell'operatore = all'interno del costruttore di copia, in quanto non sappiamo se this è stato allocato e non sappiamo se i suoi campi sono inizializzati o meno.

### Dichiarazione di variabile con inizializzazione

```cpp
Stack s1 = s2;
```

Viene invocato il costruttore di copia, NON l'operatore di assegnamento.

## Rule of three (regola del tre)

Quando dobbiamo re-implementare uno dei 3 elementi sopra specificati, allora dobbiamo ridefinirli tutti e tre.
È impossibile che sia necessario implementarle solo uno dei 3.

### Esempio applicazione regola del 3 mediante tre classi

In caso avessimo 2 classi che utilizzano memoria dinamica (A, B) e una terza classe che utilizza come attributi A a e B b;

Classe A e Classe B dovrebbero implementare la rule of three.
La Classe Myclass non deve ridefinire il distruttore, in quanto:

- Il distruttore, dopo aver eseguito il codice se esplicito, richiama un distruttore per ogni field
- In questo caso, dato che i field sono due oggetti di due classi di cui abbiamo definito il relativo distruttore, verrà richiamato direttamente il loro distruttore


## Funzioni generiche - funzioni templatiche

Vogliamo creare funzioni uniche (es. funzioni per scambiare due valori) rendendo generico il tipo dei parametri.
Sarà il compilatore a specializzare la funzione per i data type che passiamo come parametri.

### Sintassi

```cpp
template <typename T> // oppure template <class T>
void scambia (T& x, T& y){...}
```

Posso specificare più typename.
È una funzione templatica.
Meta programmazione → non è codice direttamente eseguibile.
A seconda dei datatype dei parametri formali, verranno istanziate funzioni diverse.
I datatype possono essere sia primitivi che oggetti.

Vantaggi:

- Scrivo un'unica funzione generica per più datatype
- NO ridondanza del codice


### Funzionamento per le funzioni templatiche

Se non abbiamo specificato gli overloading per gli operatori delle classi, le funzioni templatiche che utilizzano tali operatori non funzioneranno → dobbiamo esplicitare gli overloading.
Funzioneranno solo per i datatype primitivi.

### Specifica di più parametri generici (T1, T2)

Posso specificare più parametri generici.
Essi potranno essere di datatype diversi, ma anche uguali.

## Template di classe

Così come le funzioni templatiche, è possibile realizzare delle classi "generiche" / templatiche.

### Sintassi

```cpp
template <typename T>
class C {...}
```

Il parametro generico della classe è possibile utilizzarlo solo all'interno della classe.

Nel main, dovrò specificare la tipologia della mia classe mediante:

```cpp
Stack<int> s1; // vado ad inizializzare uno stack di interi
```


### Problema con overloading al di fuori della classe

Avendo l'overloading di stampa e di input al di fuori della classe, tipo generico T della classe non può essere utilizzato.
Dobbiamo definirla come una funzione templatica e, quando gli passiamo l'oggetto, lo specializziamo come Oggetto<T>.

### Creazione di oggetti

[!] Non c'è nessuna relazione tra Stack di tipo diversi [!]
Stack<int> != Stack<float> != Stack<Razionale>

## Standard Template Library (STL)

STL non fa parte della standard library.
C++ mette a disposizione strutture dati e algoritmi generici.

STL contiene:

- Containers
- Iterators
- Algoritmi
- Funtori


### Containers

Contiene collezioni di elementi di tipo T.
Differiscono per:

- Criterio di aggregazione
- Modalità di selezione degli elementi

Esempio di classi messe a disposizione:

- list<T>
- vector<T>
- stack<T>
- set<T>
- multiset<T>
- map<T1, T2>


### Classe vector<T>

Realizza il tipo di dato astratto vettore → simile ad array, vector può crescere dinamicamente.
Templatica per un parametro, ossia il tipo del vector.
Realizzata mediante array dinamici → memoria viene aumentata dinamicamente quando necessario.
La memoria inutilizzata serve per future crescite del vettore.
La riallocazione è un'operazione costosa, si cerca di farla meno volte possibile.
Sono numerosi passaggi, tra cui nuovo array, copia degli elementi del vecchio array nel nuovo, deallocazione del vecchio array.

Include:

```cpp
#include <vector>
```


#### Proprietà

- Size → numero di elementi presenti nel vettore
- Capacity → memoria disponibile


#### Costruttori

- vector() → crea un vettore vuoto, size = capacity = 0
- vector (int n) → crea un vettore di dimensione n
- vector(int n, const T\& k) → crea un vettore con n elementi inizializzati al valore k


#### Metodi generali

- size()
- capacity()
- empty()
- clear() → elimina tutti gli elementi del vettore, size = 0
- push_back(x)
- pop_back()


#### Metodi overloaded

- operator=
- operator[] → accesso agli elementi tramite indice
- operator==, !=, …


### Altri contenitori di tipo sequenziali

- list<T> → lista doppiamente concatenata, accesso sequenziale
- stack<T> → accesso LIFO
- queue<T> → FIFO


### Containers associativi

- set<T> → collezioni di elementi non duplicati di tipo T
- multiset<T> → collezioni di elementi anche duplicati di tipo T
- map<T1, T2> → insieme di elementi coppia chiave-valore
    - Chiave → T1
    - Valore → T2


### DA GUARDARE PER ESAME

- class set
- class vector
- Algoritmi
    - sort
    - merge
    - reverse
    - swap


### Esercizio Map rivisto

Implementiamo una Map mantenendo la classe Pair, ma sostituendo container e rendendolo un Set.
Il set sarà di tipo Pair, rispettivamente avendo coppia chiave-valore.

### Utilizzo del foreach

Utilizzato spesso per iterare su strutture dati.
Ogni elemento iterato, se non diversamente specificato, è restituito per copia.

Nella funzione add, in caso la coppia esista già e vogliamo modificarla, dobbiamo modificare l'elemento di this->container di tipo Pair, modificando lui stesso e non una copia.

### Keyword "auto"

È il compilatore a dedurre automaticamente che tipo ha l'oggetto su cui si sta iterando.

### Utilizzo di vector al posto di set

Per risolvere il problema del return per reference dell'iterator, andiamo a sostituire set con vector.

### Rule of three per i containers

Se utilizziamo dei containers, sono loro a occuparsi della allocazione / deallocazione della memoria.
Non è necessario quindi ridefinire "la rule of three", in quanto la gestiscono loro.

## CLASS VECTOR - METODI PRINCIPALI

### Accesso agli elementi

- at → accesso ad uno specifico elemento mediante indice (no bound checking)
- operator[] → accesso ad uno specifico elemento mediante indice
- front → accesso al primo elemento
- back → accesso all'ultimo elemento
- begin → accesso all'inizio del vector. Tipicamente utilizzato per indicare la posizione di inserimento nel metodo insert / erase


### Capacity

- empty → controlla se il vector è vuoto oppure no
- size → restituisce il numero di elementi
- capacity → restituisce il numero di elementi che possono essere contenuti nello storage riservato al vector


### Modificatori

- clear → elimina tutti gli elementi nel vector
- insert → inserisce un elemento
    - Parametri: posizione in cui l'elemento verrà inserito prima, valore da inserire
- erase → elimina un elemento
    - Parametri: posizione in cui si trova l'elemento da rimuovere
- push_back → inserisce un elemento in fondo
- pop_back → rimuove l'ultimo elemento
- resize → cambia il numero di elementi memorizzabili


## CLASS SET - METODI PRINCIPALI

### Capacity

- empty → controlla se il set è vuoto oppure no
- size → restituisce il numero di elementi
- max_size → restituisce il numero massimo di elementi che possono essere memorizzati
- count → conta il numero di occorrenze di un dato parametro
    - Parametri: elemento di cui contare il numero di occorrenze


### Modificatori

- clear → elimina tutti gli elementi nel set
- insert → inserisce un elemento nel set
- erase → elimina un elemento
    - Parametri: elemento da eliminare
- swap → scambia due set tra loro
    - Parametri: il set con cui scambiarsi


## PARTE JAVA

### Introduzione a Java

Linguaggio orientato a oggetti.
Sintassi simile a C++, con alcune semplificazioni.
Non c'è aritmetica dei puntatori vista in C++.

### Portabilità

Programma scritto in Java: Programma.java

- compilazione (javac) → genera Programma.class (Java bytecode)
- Interpretazione (java)
    - JVM
    - Macchina host


### Struttura di un programma

Non è previsto uno spazio globale, come in C++.
Tutte le funzioni e i dati sono necessariamenti interni a classi.
Ogni classe va in un file separato.
Il nome della classe deve essere uguale al nome del file.
Convenzione: prima lettera maiuscola.

Il punto di ingresso di un programma (ossia il solito "main") è una funzione:

- public
- static
- void
- ha come parametro un array di stringhe


### Output

Sintassi:

```java
System.out.println("Ciao!")
```

Semantica:

- Invio allo stdout una stringa specificata come parametro
- Invoco il metodo println sull'oggetto out, il quale è un campo della classe System


### Input

Sintassi:

- import → `import java.util.Scanner;`
- creazione oggetto → `Scanner sc = new Scanner (System.in)`
    - sc è una reference all'oggetto Scanner, creato dinamicamente mediante l'istruzione new
    - sc leggerà gli elementi prendendoli da System.in (stream di input)

Utilizzo → `x = sc.nextInt()`

- nextInt() → metodo della classe Scanner
- ritorna, se possibile, il primo numero intero presente nello stream a cui sc è "collegato"


### Installazione

Installa JDK SE.
JDK deve essere >= 11 (e minore di 17).

### Runnare java file su terminale

```bash
javac <nomefile>.java
```

Verrà generato un file <nomeclasse>.class

```bash
java <nomefile>.java
```


### Puntatori (C++) vs Reference (Java) + passaggio per valori

In C++, abbiamo visto l'utilizzo di puntatori come variabili che contengono degli indirizzi di memoria di altre variabili.

In Java, non esistono i puntatori, bensì le reference.
In particolare, ogni volta che passiamo, ad esempio, un oggetto ad una funzione, il passaggio avviene per valore.
Se nella funzione l'oggetto viene modificato, tale modifica si propagherà all'oggetto originale → viene modificato l'oggetto e tale modifica permane anche dopo la chiamata a funzione.
Ciò avviene perché la variabile (oggetto) memorizza un indirizzo di memoria, in cui (in tale indirizzo) sono contenuti i dati del nostro oggetto.
Passando per valore un oggetto quindi, passiamo per valore tale indirizzo di memoria e, andando a modificare l'oggetto, non andiamo a modificare una copia, bensì l'oggetto stesso.

È come se stessimo applicando un passaggio per reference, ma nella realtà passiamo per valore un indirizzo di memoria, ed è per questo motivo che le modifiche si propagano.

## Tipi primitivi

- int
- char
- float e double
- boolean

Non c'è compatibilità tra alcuni data type, come era invece in C++.
boolean è distinto dal tipo intero.
L'insieme dei valori per ciascun tipo + specificato dal linguaggio, in particolare dalla JVM.
Standard per i char è UNICODE a 16 bit (che include ASCII).

### Conversioni

Converte implicitamente valori di tipo più piccolo in valori di tipo più grande.
es. double convertito in float, ma non viceversa.
Se vogliamo fare troncamento con perdita di precisione, si fa un cast esplicito.

### Statement

Molto simili a C++.

### Struttura

Tutte le funzioni / campi devono essere all'interno di una classe.
Non esiste uno spazio globale, a differenza di C++.
Tutte le funzioni sono metodi → non esiste il vero e proprio concetto di funzione, in quanto le funzioni devono essere all'interno di classi.
È possibile fare overloading di metodi.
Non è previsto l'overloading di operatori.

### Passaggio dei parametri

In C++, si può passare per valore o per riferimento (sia tipi primitivi che oggetti).

In Java, esiste solo il passaggio per valore:

- Tipi primitivi → passaggio solo per valore
- Tipi reference → passaggio per riferimento
- Se passo per valore un tipo reference, è come se stessi passando per riferimento


### Stringhe in Java

Le stringhe in Java contengono una reference (ossia una stazione di puntatore) alla vera e propria stringa.
Le stringhe sono immutabili.

### Classi wrapped

Ogni tipo primitivo è boxato / racchiuso dentro una classe specifica.
es. int è racchiuso dentro la classe Integer.

### Classi

Valgono gli stessi concetti di information hiding, incapsulamento, … di C++.
Valgono gli stessi concetti del Costruttore visti in C++.
Per ogni attributo va specificata la sua visibilità (private, public).

### Oggetti

Tutti gli oggetti sono allocati dinamicamente → SEMPRE con l'operatore NEW.
Reference agli oggetti → allocati nello Stack.
Oggetti veri e propri → allocati nello Heap.

Esempio:

```java
C1 x; // vado a creare una variabile di tipo reference che "punta" a null (non vado a chiamare nessun costruttore)

x = new C1(); // alloco oggetto nello heap, chiamo costruttore senza parametri di C1
// Viene returnata una reference, in modo che x "punti" al nuovo oggetto allocato nello heap
```

Non sarà necessario ridefinire la rule of three per gli oggetti.
Dato che verranno copiate le reference, in modo che entrambi le reference "puntino" allo stesso oggetto.

Come si accede a metodi e campi? (dato che ho una reference all'oggetto, non l'oggetto vero e proprio)
Non possiamo dereferenziare una reference → lo fa lui in automatico.
Unica annotazione possibile per accedere ad un oggetto è la dot (.) notation.

### This

Esiste un puntatore implicito all'oggetto, proprio come in C++.

### metodo toString

metodo presente in ogni classe.
Di default, se non specificata, stampa la reference.
Se voglio effettuare override, specifico il formato della stringa che voglio stampare con System.out.println();

### Delega dei costruttori

All'interno del metodo, chiamo this come metodo.
Deve essere la prima linea di codice dentro a quello specifico metodo.

Sintassi:

```java
this(1, 1, 1970);
```


### Controllo fra reference

Se due reference non puntano allo stesso oggetto, confrontandole (d1 == d2), risulterà false.
Se assegno un oggetto ad un altro con l'operatore =, avranno la stessa reference (punteranno allo stesso oggetto).

### metodo equals

Metodo presente in ogni classe.
Permette di confrontare due oggetti (e non due reference a oggetti).

## Tipi

- Primitivi → int float, char, …
- Reference →
    - Tipi predefiniti → array, ogni array è un oggetto
    - Definiti il librerie → String, Integer, List, Set, …
    - Definiti dall'utente


### Array

Sintassi:

```java
int[] a; // Sto dichiarando una reference a, ma non alloco nulla ("a" contiene null)
```

Anche gli array possono essere allocati solo dinamicamente → non va specificata la dimensione in fase di dichiarazione.
Sono zone contigue di memoria.

```java
int[] a = new int[^1_10];
```

"a" contiene la reference all'array di dimensione 10.

#### Array "semi-dinamici"

È possibile inserire come dimensione dell'array anche una variabile, quindi specificata a runtime.

#### Array bi-dimensionali / k-dimensionali

Non sono zone contigue di memoria.
VI è una reference ad un array di reference, in cui ogni cella c'è una reference all'array "più interno".

### Operatori di selezione

Analoghi a quelli visti in C++.
Se l'indice dell'array esce dai limiti della dimensione dell'array stesso, viene sollevata una eccezione (a differenza di C++).
Ciò perché gli array sono dei veri e propri dati astratti.

### "Proprietà"

Ogni array ha una proprietà, ossia la lunghezza → array.length.
Hanno un metodo equals → confrontano le reference (reference quality), NON gli array veri e propri.
Hanno un metodo toString → stampano la reference, non il contenuto dell'array.
Se utilizzo operatore di assegnamento "=", le reference "punteranno" allo stesso array.
Stessa cosa per operatori di confronto (==, !=).

### Array - passaggio di parametri

Il passaggio di reference avviene comunque per valore ma, andando a passare una reference, si avrà side-effect, quindi le modifiche fatte ad un array (ad esempio in una funzione) si propagheranno anche all'array originale.

### Deallocazione della memoria dinamica

Pro:

- In C++ è necessario deallocare la memoria
- In Java, ciò è fatto da un programma interno della JVM → non dobbiamo occuparcene noi
- Se qualcosa è garbage, ci pensa il garbage collector

Contro:

- Il programmatore non ha controllo sulla memoria
- L'attività del garbage collector rallenta l'esecuzione del programma [DA PROVARE]

Per sistemi embedded → consigliato utilizzare linguaggi di basso livello (C++).

## Classe String

Sono istanze della classe String.
NON sono implementate come array di caratteri, con carattere terminatore come ultimo carattere.

```java
String s; // s è una reference a null
```


### Costruttori della classe

- Senza parametri → `String e = new String();`
- Con parametri, di tipo array di caratteri:

```java
char elem[] = {'h', 'e', 'l', 'l', 'o'};
String e = new String(elem);
```

"e" è una reference alla stringa vera e propria


### Stringhe costanti

```java
String s = "hello"
```

La costante "hello" è un oggetto della classe String.

### Costruttore di copia

```java
String s = new String(a); // crea una copia della stringa "a"
```


### Immutabili

Le stringhe sono immutabili → non è possibile alterare il loro contenuto.

```java
s.charAt(index) = 'm'; // ERRORE, le stringhe sono IMMUTABILI
```


### Leggere una stringa da standard input

Si utilizza sempre la classe Scanner, in particolare:

```java
sc.nextLine();
```


### Concatenazione

È possibile concatenare stringhe utilizzando l'operatore primitivo "+":

```java
String s = "hello";
String r = s + "world";
```

Tutte le altre operazioni sono implementati mediante metodi della classe String.

### Metodi

- length()
    - `stringa.length()` → restituisce la lunghezza della stringa
    - `"abc".length();` → è possibile farlo, dato che le costanti fanno parte della classe String
    - Non si può fare overloading dei metodi → non è possibile accedere con operatori "[]"
    - Per accedere ad un carattere → `stringa.charAt(index);`
    - Ritorna il carattere della stringa all'indice specificato
    - Se è fuori dai range, viene lanciata una eccezione
- s.indexOf(c)
    - ritorna l'indice della prima occorrenza del carattere c nella stringa s
    - Se il carattere non è presente nella stringa, ritorna -1
- s.substring(init, end)
    - se init e end sono interi compresi fra 0 e s.length() - 1 →
    - il metodo ritorna la stringa compresa fra init ed end - 1
    - Se end non è presente, viene impostato di default end = s.length() - 1
    - Se gli indici sono fuori dal range, viene lanciata una eccezione


### Assegnamento

Come per gli array, l'assegnamento fra oggetti di tipo String comporta un assegnamento fra reference:

```java
String s = "hello";
String r = s;
```

r ed s "puntano" alla stessa reference.

### Operatore "=="

Anche l'operatore di confronto si applica alle reference, e non al contenuto delle stringhe vere e proprie.

#### Ottimizzazione della JVM

```java
String s = "hello";
String r = "hello";
if (s == r)... // ritorna true
```

La JVM, invece che allocare due oggetti, è ottimizzata per far si che due stringhe con lo stesso contenuto siano due reference allo stesso oggetto.

Se voglio confrontare il contenuto delle stringhe, utilizzo il metodo equals messo a disposizione dalla classe String.
In realtà, tutte le classi Java hanno un metodo equals.

### Final keyword

- Sulle variabili → la variabile diviene una costante
- Sui metodi → il metodo non può essere riscritto, ossia non può avvenire override
- Sulle classi → le classi non possono essere estese

Sugli attributi delle classi:

- Deve essere inizializzato nel costruttore
- non può essere modificato al di fuori del costruttore


## Tipi (ripasso)

- Primitivi
- Reference
    - predefiniti → Array (sono vere e proprie classi)
    - Definiti in librerie → String, List, Set
    - Definiti dall'utente


### Approccio totalmente orientato agli oggetti

#### Classi wrapper

Per fare ciò, Java mette a disposizione delle classi wrapper.
Per ogni tipo primitivo esiste una classe wrapper che è di tipo reference.
La classe wrapper "avvolge" / "incapsula" il tipo primitivo → operazione di boxing.

Tipi primitivi → classi wrapper:

- byte → Byte
- short → Short
- int → Integer
- long → Long
- float → Float
- double → Double
- char → Character
- boolean → Boolean

Valgono le stesse cose già dette per i tipi reference:

- Allocati nello heap
- Hanno dei loro metodi
- Quando alloco, ho delle reference al vero e proprio oggetto (es. oggetto di tipo Integer)


#### Sintassi

```java
Integer x = 3; // sto inizializzando un Integer con un dato primitivo int, Java fa autoboxing
Double z = 2.1;
```

Dato un oggetto wrapper, come recuperare il valore primitivo contenuto?
Esempio per la classe Integer:

```java
x.intValue(); // operazione di unboxing
```


#### Boxing e unboxing

Boxing e Unboxing vengono eseguite automaticamente.
Non è necessario (per forza) utilizzare i relativi metodi per fare unboxing, e non è necessario utilizzare il costruttore di una classe wrapper per wrappare un dato primitivo.

È come se il tipo primitivo e la relativa classe wrapper siano la "stessa cosa".

#### Caratteristiche e metodi

Sono immutabili (come le stringhe).
Se riassegno una classe wrapper viene creato un nuovo oggetto.

#### toString

Restituisce una nuova stringa con il valore del tipo primitivo.

#### Confronto tra classi wrapper

```java
Integer i = 3; Integer j = 3; // i == j restituisce true
Integer i = 200; Integer j = 200; // i == j restituisce false
```

Ciò accade perché, nel primo caso, viene utilizzato un singolo oggetto per entrambi, senza allocarne uno nuovo (sono quelli che verranno utilizzati di più, quindi fa caching).
Nel secondo caso, dai valori tra -128 e 127, vengono creati due oggetti diversi e, confrontando quindi le loro reference, restituisce false.

Per fare confronti senza sbagliarsi, è bene utilizzare il metodo equals (messo a disposizione per ogni classe).

Quando il boxing è esplicito (utilizzo il costruttore in modo esplicito), restituirà sempre false.

#### Costruttore delle classi wrapper

È deprecato.
Al suo posto deve essere utilizzato `<classe_wrapper>.valueOf(<valore primitivo>);`

#### Metodo Parse

Data una stringa, ritorna l'oggetto wrapper corrispondente.
È un metodo di classe → è "richiamato" dalla classe, non ad una particolare istanza.

Esempio:

```java
Integer.parseInt(s);
```

Se possibile → ritornerà un oggetto di tipo Integer.
Altrimenti viene lanciata una eccezione NumberFormatException.

#### Metodo equals

Se ho una classe creata da me, essa possiede il metodo equals, ma non è ben definito e fa la reference quality (confronta le reference).
Posso ridefinire il metodo equals.
Prende come parametro un oggetto qualsiasi.
Object obj → oggetto generico.

### Eccezioni (generiche)

Per lanciare una eccezione (PER ORA) utilizziamo una eccezione generica:

```java
throw new RuntimeException(<messaggio_errore>);
```


#### Metodo clone

Metodo che crea un clone dell'oggetto chiamante (this).
È un metodo più o meno standard di ogni classe.

## Elementi di classe

Classe composta da:

- Attributi
- Metodi

Istanze degli oggetti sono reference agli oggetti veri e propri (sono "puntatori" alla zona di memoria che contiene attributi dell'oggetto).

### Elementi di istanza di una classe

tutti gli attributi e metodi visti fino ad ora sono detti di istanza:

- Campo d'istanza → istanza di una classe che mantiene una copia degli attributi dell'oggetto
- Metodi d'istanza → metodi applicabili ad una istanza di una classe


### Classi singleton (?)

Classi che permettono di creare una sola istanza.
Potrebbe essere utile per tenere traccia del numero di istanze allocate di un'altra classe (es. Punto).
Contare il numero di istanze create.
Non posso creare un attributo normale:

- Ogni istanza avrà un proprio valore di tale attributo (e saranno tutti = 1)
- Non è un contatore / attributo ""globale"" per tutte le istanze

Ho bisogno di una proprietà di classe → comune a tutte le istanze, è relativa alla classe e non alle istanze.

#### Static attributes

Sono attributi di proprietà di classe, non di istanza.
Sono condivisi fra tutte le istanze di quella particolare classe.

Sintassi:

```java
private static x = 0;
```

Fornisco un metodo get per restituire il valore di tale attributo statico.

Come chiamarlo?
Non ha senso chiamarlo da una particolare istanza di classe.
Il metodo non modifica le proprietà di this, è relativo alla classe.
Ho bisogno di un metodo static → metodo di classe.
→ nel main andrà invocato sulla classe, non su qualunque istanza.

Se un metodo è static, NON può andare a modificare this.

#### Variabili costanti

Posso dichiarare variabili costanti nel main utilizzando sempre la keyword static.
Per far sì che non sia modificabile, aggiungo anche la keyword final.

### Classe Math

Corrispondente alla libreria <cmath> in C++.

### Classe Arrays

Comprende operazioni effettuabili su Array.

### Classi templatiche

Per definire classi templatiche → `public class [NomeClasse]<T> {...}`

#### Metodi statici e templatici

Dato che il metodo è static, il suo data type non verrà specializzato da una particolare istanza di una classe (come accadeva per le normali classi templatiche in C++), dato che il metodo verrà richiamato sulla classe stessa e su nessuna istanza.
In java, se voglio un metodo static e templatico, devo reintrodurre il type parameter T.

Sintassi:

```java
public static <T> boolean search(T x, T y) {...}
```


#### Classi che non è possibile istanziare

Se voglio creare una classe generica, non voglio che vengano create istanze di quella classe (es. classe Arrays, messa a disposizione da Java).
Per fare ciò, rendo il costruttore privato.

#### Differenza C++ e Java

```java
public static <T> T max(T[] x){
    if (x == null)
        return null;
    
    T max = x[^1_0];
    
    for (int i = 0; i < x.length; i++) {
        if (x[i] > max)
            max = x[i];
    }
    return max;
}
```

Tale metodo non compila, perché:
non ho definito l'overloading per l'operatore "<" o ">" e in Java NON è possibile effettuare overloading di alcun operatore.

[!] In C++, tale metodo compilava in base al data type "T" che passavamo [!]
Se tale data type (es. Razionale) aveva definito l'overloading di tale operatore, alloca compilava (altrimenti no).

Per far si che compili, devo specificare che il tipo T potrà essere solo di determinati type parameter.

Utilizzo Comparable

<div style="text-align: center">⁂</div>

[^1_1]: paste.txt

