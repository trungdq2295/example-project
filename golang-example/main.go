package main

import "fmt"

var test, a int = 2, 4 //global variable
var python bool

func main2() {
	loop(5)
	while(5)
	var i int
	var f float64
	fmt.Println(i, f)
	ifStatement(5)
	ifStatement(0)
	ifStatement(-1)
	switchStatement("a")
	deferStatement()
	//deferWithLoop()
}

func loop(n int) {
	newN := n + 1
	for i := 1; i <= newN; i++ {
		fmt.Println(i)
	}
}

func while(n int) {
	sum := 0
	for sum < n {
		sum++
		fmt.Println(sum, n)
	}
}

func ifStatement(n int) {
	if n > 0 {
		fmt.Println("ok")
	} else if n == 0 {
		fmt.Println("2")
	} else {
		fmt.Println("3")
	}
}

func switchStatement(abc string) {
	switch abc = abc + ";"; abc {
	case "a;":
		fmt.Println("a")
	case "b":
		fmt.Println("b")
	default:
		fmt.Println("default")
	}
}

/*
*

	Defer is mean to execute later after other line of code is finished

and it works like a stack
*/
func deferStatement() {
	//d := 2
	//defer fmt.Println(d)        // this wait other line of code is finish then go into this
	//defer fmt.Println("454546") // this wait other line of code is finish then go into this
	//
	//fmt.Println("hello")
	//fmt.Println("132312")
	//fmt.Println("312312454545")
	//d += 5
	//fmt.Println(d)
}

/**
Defer work like a stack FILO

*/

func deferWithLoop() {
	fmt.Println("counting")

	for i := 0; i < 10; i++ {
		defer fmt.Println(i)
	}

	fmt.Println("done")
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
