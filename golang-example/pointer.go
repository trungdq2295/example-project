package main

import "fmt"

type TN struct {
	name string
	age  int
}

var v1, v2 = TN{"hello", 20}, TN{"world", 30}

func main5() {
	//pointer()
	//structInGo()
	//fmt.Println(array())
	spliceArray()
}

func pointer() {
	var i, j int = 1, 2

	var p = &j // point to j
	fmt.Println(i)
	*p += *p + 1
	fmt.Println(*p)
	p = &i // point to i
	fmt.Println(*p)
}

func structInGo() {
	tn := &v1
	fmt.Println(tn.name)
	tn.name = "ab"
	fmt.Println(tn.name)
}

func array() [2]string {
	var a [2]string
	a[0] = "hello"
	a[1] = "world"

	return a
}

/*
Remember, you have to use []T if you want an array with dynamic size
*/
func spliceArray() {
	primes := [6]int{2, 3, 5, 7, 11, 13}
	s := primes[1:4] // reference to original array
	primes[1] = 12
	fmt.Println(primes)
	fmt.Println(s)
	s = append(s, 5, 4, 3)
	fmt.Println(s)

	a := make([]int, 5)
	a[4] = 1
	fmt.Println(cap(a))
	fmt.Println(a)
}
