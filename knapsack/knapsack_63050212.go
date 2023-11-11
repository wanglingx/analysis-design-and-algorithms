package main

import (
	"fmt"
	"runtime/debug"
)

var size, count int
var W float64
var wei float64 = 0
var vw = make([]float64, size)

func main() {
	//input data
	fmt.Print("identify your size problem > ")
	fmt.Scan(&size)
	var value = make([]float64, size)
	var weight = make([]float64, size)
	for i := 0; i < size; i++ {
		fmt.Print("add value > ")
		fmt.Scan(&value[i])
		fmt.Print("add weight > ")
		fmt.Scan(&weight[i])
		fmt.Println("--------------------------------")
	}
	fmt.Print("Capacity Bag W > ")
	fmt.Scan(&W)
	//knapsack
	display(weight, value, size)
	fmt.Print("Total Value >> ")
	//fmt.Println(knapsack(W, weight, value, size) + wei)
}
func knapsack(W float64, weight []float64, value []float64, n int) float64 {
	total_weight := 0.0

	if n == 0 || W == 0 {
		return 0
	}
	if weight[n-1] <= W {
		fmt.Println(value[n-1]," ",W)
		total_weight = max(knapsack(W, weight, value, n-1), value[n-1]+knapsack(W-weight[n-1], weight, value, n-1))
	}
	if weight[n-1] > W {
		count++
		return knapsack(W, weight, value, n-1)
	}
	return total_weight
}

func max(a float64, b float64) float64 {
	if a > b {
		return a
	}
	return b
}

func display(weight []float64, value []float64, size int) {
	defer func() {
    	if panicInfo := recover(); panicInfo != nil {
      		fmt.Printf("%v, %s", panicInfo, string(debug.Stack()))
    	}
  	}()

	var vw = make([]float64, size)
	//var temp = make([][]float64,5,size)
	for i := 0; i < size; i++ {
		vw[i] = value[i] / weight[i]
		fmt.Printf("%.1f/%.1f = %.2f  ", value[i], weight[i], vw[i])
	}
	fmt.Println()
	//sort
	for i := 0; i < 5 ;i++{
		
		if vw[i] < vw[i+1] {
			if i == -1 {continue}
			temp := vw[i]
			vw[i] = vw[i+1]
			vw[i+1] = temp
		}
	}
	fmt.Println(vw)
}
