#include <iostream>
using namespace std;

/*

Si definisca la classe Complex dei numeri complessi con un costruttore
con due parametri che inizializza l'oggetto corrispondente ad un numero complesso con la parte reale
e la parte immaginaria. Si sovraccarichino gli operatori ==, != (per poter confrontare numeri complessi), +, -
(per poter effettuare somme e sottrazioni fra numeri complessi), >> e << (operatori di estrazione ed inserimento).
Si massimizzi l'incapsulamento e l'information hiding.

 */

class Complex {
private:
    int parteReale;
    int parteImmaginaria;

public:
    Complex() : Complex(1, 1) {}

    Complex(int parteReale, int parteImmaginaria) {
        this->parteReale = parteReale;
        this->parteImmaginaria = parteImmaginaria;
    }

    int getParteReale() const {
        return parteReale;
    }

    void set_parte_reale(int parte_reale) {
        parteReale = parte_reale;
    }

    int getParteImmaginaria() const {
        return parteImmaginaria;
    }

    void set_parte_immaginaria(int parte_immaginaria) {
        parteImmaginaria = parte_immaginaria;
    }


    bool operator==(const Complex& other) const {

        return this->parteReale == other.parteReale && this->parteImmaginaria == other.parteImmaginaria;

    }

    bool operator!=(const Complex& other) const {
        return !(*this == other);
    }

    Complex operator+(const Complex& other) const {

        Complex final;

        final.parteReale = this->parteReale + other.parteReale;
        final.parteImmaginaria = this->parteImmaginaria + other.parteImmaginaria;

        return final;
    }

    Complex operator-(const Complex& other) const {
        Complex result;

        result.parteReale = this->parteReale - other.parteReale;
        result.parteImmaginaria = this->parteImmaginaria - other.parteImmaginaria;

        return result;
    }

    void stampa(ostream& out) const {
        if (this->parteImmaginaria >= 0) {
            cout << this->getParteReale() << " + " << this->getParteImmaginaria() << "i" << endl;
        } else
            cout << this->getParteReale() << " - " << this->getParteImmaginaria() * (-1) << "i" << endl;
    }
};

ostream& operator<<(ostream& out, const Complex& c1) {

    c1.stampa(out);


    return out;
}

istream& operator>>(istream& in, Complex& c1) {

    int reale, immaginaria;

    cout << "Inserisci parte reale: ";
    in >> reale;

    c1.set_parte_reale(reale);

    cout << "Inserisci parte immaginaria: ";
    in >> immaginaria;

    c1.set_parte_immaginaria(immaginaria);

    return in;
}


int main() {

    Complex c1(5, -4);
    Complex c2(5, 9);

    Complex c3;

    Complex result  = c1 - c2;

    cout << result;

    if (c1 == c2)
        cout << "C1 e C2 sono uguali!" << endl;
    else if (c1 != c2)
        cout << "C1 e C2 NON sono uguali!" << endl;

    cin >> c3;

    cout << c3;


    return 0;
}