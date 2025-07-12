package main

import "fmt"

/*
How interface works?
interface values can be thought as a tule of value and concrete type
(value, type)
for example

	var tnInterface TrungNguyenInterface
		myTn := MyTn{
			id:   1,
			name: "12312312",
		}
	tnInterface := myTn

This mean tnInterface be like (value: myTn, type: MyTn)
Be careful of nil value
*/
type TrungNguyenInterface interface {
	doSomething3232()
}

type MyTn TrungNguyen

/*
This mean type myTn implement the interface TrungNguyenInterface
But we don't need to explicitly declare that it does so
*/
func (mytn MyTn) doSomething3232() {
	print(mytn.id)
}

//func (tn *TrungNguyen) doSomething3232() {
//	print("Do something")
//}

func (tn *TrungNguyen) doSomething3232() {
	if tn == nil {
		fmt.Println("nil TrungNguyen")
		return
	}
	tn.id = 2
}

//func main() {
//	//interFaceExample()
//
//	//emptyInterface()
//
//	//tyeAssertion()
//	switchCaseInterface()
//}

func interFaceExample() {
	var tnInterface TrungNguyenInterface
	myTn := MyTn{
		id:   1,
		name: "12312312",
	}

	tn123 := TrungNguyen{
		id:   1,
		name: "321312",
	}

	x := &tn123
	fmt.Println(x)

	var tnNil = &TrungNguyen{
		id: 5,
	}
	tnInterface = tnNil
	tnNil.doSomething3232()
	fmt.Println(tnNil)

	tnInterface = myTn
	//tnInterface = tn123 // this will cause compile error because it doesn't have method of interface
	//tnInterface = x // however, this will be fine since we do have a method pointer tn *TrungNguyen implement method of interface
	tnInterface.doSomething3232()

}

/*
*
Just think go is like javascript
lol

You can assign any type to an empty interface
*/
func emptyInterface() {
	var i interface{}
	fmt.Println(i)
	i = 42
	fmt.Println(i)

	i = "TN"
	fmt.Println(i)
}

func tyeAssertion() {
	var i interface{} = "hello"

	/**
	We gonna assign the value of s
	if i has right type for we want, s will get that value and ok is true
	If not, s will get default value of that type and ok will be false
	*/
	s, ok := i.(int)
	fmt.Println(s, ok)

	f, ok := i.(string)
	fmt.Println(f, ok)
}

func switchCaseInterface() {
	var i interface{} = "hello"

	switchCaseExample(i)
	i = 456
	switchCaseExample(i)
}

func switchCaseExample(i interface{}) {
	switch i.(type) {
	case int:
		fmt.Println("int")
	case string:
		fmt.Println("string")
	}
}
