#include <iostream>
using namespace std;

class Point {
protected:
    int x;
    int y;

public:
    Point() : Point(0, 0) {}

    Point(int x, int y) {
        this->x = x;
        this->y = y;
    }

    int getX() const{
        return this->x;
    }

    int getY() const {
        return this->y;
    }

    void setX(const int x) {
        this->x = x;
    }

    void setY(const int y) {
        this->y = y;
    }

    void visualizzaDettagli() const {
        cout << "(" << this->getX() << ", " << this->getY() << ")" << endl;
    }

    void spostaPuntoX(int moveX) {
        this->x += moveX;
    }

    void spostaPuntoY(const int moveY) {
        this->y += moveY;
    }

    bool equals(const Point& other) const {
        return this->x == other.x && this->y == other.y;
    }


};


class Circle : public Point {
private:
    double raggio;

public:
    Circle() : Circle(0, 0, 1){}

    Circle(int x, int y) : Circle(x, y, 1){}

    Circle(int x, int y, double raggio) : Point(x, y) {
        if (raggio > 0)
            this->raggio = raggio;
        else throw invalid_argument("Valore del raggio non valido!");
    }

    double getRaggio() const {
        return this->raggio;
    }

    void visualizzaDettagli() const {
        Point :: visualizzaDettagli();

        cout << "Raggio: " << this->getRaggio();
    }

    void spostaCerchio(int x, int y, double moveR) {
        Point :: spostaPuntoX(x);
        Point :: spostaPuntoY(y);
        this->raggio *= moveR;
    }

    bool equals(const Circle& other) {

        return Point :: equals(other) && this->raggio == other.raggio;
    }

};

int main() {


    Point p1(10, 9);

    Circle c1(9, 4, 12);
    Circle c2(9, 4, 12);

    if (c1.equals(c2))
        cout << "Sono uguali!" << endl;
    else cout << "Non sono uguali..." << endl;
    return 0;
}