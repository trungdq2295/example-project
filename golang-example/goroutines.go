package main

import (
	"fmt"
	"time"
)

type Tree struct {
	Left  *Tree
	Value int
	Right *Tree
}

//func main() {
//	go say("word")
//	say("hello")
//}

func say(s string) {
	for i := 0; i < 10; i++ {
		time.Sleep(100 * time.Millisecond)
		fmt.Println("%s + %d", s, i)
	}
}

/*
Select let you wait for multiple channel to happen
As soon as one is ready, it run that code,
if more than one are ready, it pick randomly

*/

func selectExample() {
	channel := make(chan int)
	quit := make(chan int)
	abc := make(chan int)
	go func() {
		for i := 0; i < 10; i++ {
			a := <-channel
			fmt.Println(a)
		}
	}()
	go func() {
		abc <- 0
	}()
	fibonacci2(channel, quit)
}

func fibonacci2(channel, quit chan int) {
	x, y := 0, 1
	for {
		select {
		case channel <- x:
			x = y
			y = x + y
		case <-quit:
			fmt.Println("quit")
			return
		default:
			fmt.Println("default ")
			return
		}

	}
}
