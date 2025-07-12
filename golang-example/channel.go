package main

import (
	"fmt"
	"time"
)

/*
Go has a built-in function channel which acts as receiver and sender( maybe like message queue?)
The receiver should be in ready state before sender send the message to channel
If you want to avoid this, you can create a channel with buffer size so the sender can send message to that buffer
*/
func sum(s []int, channel chan int) {
	sum := 0
	for _, v := range s {
		fmt.Printf("Calculating %d\n", v)
		time.Sleep(1000 * time.Millisecond)
		sum += v
	}
	channel <- sum // we give the data to the channel c
}

/*
Remember if you init receiver more than sender, It will cause exception
*/
func channelExample() {
	s := []int{7, 2, 8, 4}
	d := []int{7, 2, 8, 4}

	channel := make(chan int)
	go sum(s[:len(s)/2], channel)
	go sum(d, channel)
	fmt.Println("Waiting")
	sum1 := <-channel // this will block the code until it receive the data
	sum2 := <-channel //
	fmt.Println(sum1, sum2)
}

func channelWithBuffer() {
	channel := make(chan int, 2)
	channel <- 1
	//channel <- 3 // this will cause exception  since it exceeds the size
}

func channelClose(num int, c chan int) {
	x, y := 0, 1
	for i := 0; i < num; i++ {
		c <- x * y
		x, y = y+1, y+2
	}
	//close(c)
}

func channelCloseExample() {
	channel := make(chan int, 10)

	channelClose(5, channel)
	time.Sleep(1 * time.Second)
	fmt.Println(<-channel)
	fmt.Println(<-channel)
	fmt.Println(<-channel)
	fmt.Println(<-channel)

}

func main() {
	//channelExample()
	//channelWithBuffer()
	//channelCloseExample()
	selectExample()
}
