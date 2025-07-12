package main

import "fmt"

type TrungNguyen struct {
	id   int
	name string
}

type TestTN TrungNguyen

func (t TestTN) print123() {
	fmt.Println(t.id, t.name)
}

func (tn TrungNguyen) print() {
	fmt.Println(tn.id, tn.name)
}

/*
This will update the original pointer
*/
func (tn *TrungNguyen) doSomething() {
	tn.id++
	tn.name = tn.name + tn.name
}

/*
This will just create a deep copy of original object
so any modifier here won't affect the original object
*/
func (tn TrungNguyen) doSomething456() {
	tn.id++
	tn.name = tn.name + tn.name
}

/*
This is the same as doSomething, just different syntax
*TrungNguyen mean the parameter should be the pointer receiver (&tn)
*/
func scale(tn *TrungNguyen) {
	tn.id++
	tn.name = tn.name + tn.name
}

func doAbc(tn TrungNguyen) int {
	return tn.id
}

func main12321312() {
	tn := TrungNguyen{
		id:   1,
		name: "TN",
	}
	tn.print()
	newTN := TestTN{
		id:   2,
		name: "Nguyen",
	}
	newTN.print123()

	tn.doSomething456()
	tn.print()
	scale(&tn)
	tn.print()

	p := &TrungNguyen{
		id:   5,
		name: "TrungNguyen312321",
	}

	fmt.Println(doAbc(*p))
}
