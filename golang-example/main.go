package main

import "fmt"

var test, a int = 2, 4 //global variable
var python bool

func main() {

	for i := 1; i <= 5; i++ {
		fmt.Println(addWithName(2.0, i))
	}
	fmt.Println(python, test, a)
	var i int
	var f float64
	fmt.Println(i, f)
}

func add(x, y int) (int, int) {
	python = true
	return x + y, x * y
}

func addWithName(x, y int) (a float64, b float64) {
	c := x + 2.0 // local variable
	python = true
	a = float64(x + 2.0)
	b = float64(y) + a + float64(c)
	return
}
