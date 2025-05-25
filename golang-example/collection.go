package main

import "fmt"

func main() {
	//mapCollection()
	//xyz := func(x int, y float64) {
	//	fmt.Println("", y, x)
	//}
	//fmt.Println(compute(xyz))
	//axz := adder(5)
	//fmt.Println(axz(7))

	f := fibonacci() // call fibonnaci only once
	for i := 0; i < 10; i++ {
		fmt.Println(f()) // but this call return function 10 times
	}
}

func mapCollection() {
	var m map[string]int = make(map[string]int) // init a map
	m["a"] = 1
	m["b"] = 2
	fmt.Println(m)
}

func compute(callback func(int, float64)) int {
	callback(3, 4.0)
	abc := 4
	return abc
}

/*
*
Go is like ReactJs
*/
func adder(a int) func(int) int {
	return func(i int) int { // function in function
		fmt.Println(i)
		return a + i
	}
}

func fibonacci() func() int {
	a, b := 0, 1
	fmt.Println(a, b) // this will be trigger only once
	return func() int {
		res := a
		a, b = b, a+b
		fmt.Println(a, b)
		return res
	}
}
