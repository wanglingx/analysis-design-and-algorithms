package main

import "fmt"

const MaxUint = ^uint(0)
const MaxInt = int(MaxUint >> 1)

var n, c int
// identify your graph edit only here if you need to change
var distance = [][]int{	{0, 10, 0, 30, 45, 0}, //A
						{10, 0, 50, 0, 40, 25}, //B
						{0, 50, 0, 0, 35, 15},  //C
						{30, 0, 0, 0, 0, 20},   //D
						{45, 40, 35, 0, 0, 55}, //E
						{0, 25, 15, 12, 55, 0}, //F
}
//var distance = [6][6]int{}
var count int = len(distance)
var point int

func main() {
	// fmt.Print("n Node > ")
	// fmt.Scan(&n)
	// for i := 0; i < len(distance); i++ {
	// 	N1 := string(rune(i + 65))
	// 	for j := 0; j < len(distance); j++ {
	// 		N2 := string(rune(j + 65))
	// 		fmt.Print("Distance from Node ", N1, " To ", N2, " > ")
	// 		fmt.Scan(&distance[i][j])
	// 	}
	// 	fmt.Println("-------------------------------")
	// }
	for i := 0; i < len(distance); i++ {
		fmt.Printf("%4d \n", distance[i])
	}
	fmt.Println("-----------Process-------------")
	var sum = make([]int, count)
	var choose = make([]bool, count)
	for i := 0; i < len(choose); i++ {
		choose[i] = false
		choose[0] = true
	}
	for point < len(choose) {
		var row, col int
		minimum := MaxInt
		for i := 0; i < len(choose); i++ {
			if choose[i] == true {
				for j := 0; j < len(choose); j++ {
					if !choose[j] && distance[i][j] != 0 {
						if minimum > distance[i][j] {
							minimum = distance[i][j]
							row = i
							col = j
						}
					}
				}
			}
		}
		choose[col] = true
		point += 1
		if point == len(choose) {
			continue
		}
		sum[point] = distance[row][col]
		printGraph(row, col)
	}
	fmt.Println()
	display(sum)
}

func printGraph(row, col int) {
	edge1 := string(rune(row + 65))
	edge2 := string(rune(col + 65))
	fmt.Printf("%-4s %-6s %-4d %-7s %-4s \n", edge1,
		"-----", distance[row][col], "-----", edge2)
}

func display(sum []int) {
	ans := 0
	for i := 1; i < len(sum); i++ {
		ans = ans + sum[i]
	}
	fmt.Println("total_distance : ", ans)
}
