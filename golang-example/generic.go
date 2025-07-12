package main

func Index[T comparable](s []T, x T) int {
	for i, v := range s {
		if v == x {
			return i
		}
	}
	return -1
}

//func main() {
//	num := []int{10, 20, 15, -10}
//	fmt.Println(Index(num, 1))
//}
