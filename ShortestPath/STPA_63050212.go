package main

import (
	"fmt"
	"math"
)
//var infinity = 99
var graph = [10][10]int{}
// var graph = [10][10]int{
// 	{0,2,5,3,15},
// 	{2,0,2,3,20},
// 	{5,2,0,10,99},
// 	{3,3,10,0,20},
// 	{15,20,99,20,0},
// };
var num int
func main() {
	fmt.Println("enter vertices")
	fmt.Scan(&num)
	fmt.Println("enter number of matrix--")
	for i := 1; i <= num;i++{
		for j := 1;j<=num;j++{
			fmt.Print("ROW ",i," > ")
			fmt.Scan(&graph[i][j])
		}
		fmt.Println("-----------------------------------------")
	}
	fmt.Println("This is Matrix before solving")
	for i := 1; i <= num;i++{
		for j := 1; j <=num;j++{
			fmt.Printf("%-4d ",graph[i][j])
		}
		fmt.Println()
	}

	for k := 1; k <= num; k++ {
		for i := 1; i <= num; i++ {
			for j := 1; j <= num; j++ {
				graph[i][j] = int(math.Min(float64(graph[i][j]),float64(graph[i][k]+graph[k][j])))
			}
		}
		fmt.Println("This is shortest path matrix K = ", k)
		for i := 1; i <= num;i++{
			for j := 1;j<=num;j++{
				fmt.Printf("%-4d ",graph[i][j])
			}
			fmt.Println()
		}
	}
	
	for i := 1 ; i<=num;i++{
		fmt.Println("start from i = ",i)
		for j := 1; j <=num; j++{
		fmt.Println("Shortest Path to j = ",j," is > ",graph[i][j])
		}
		fmt.Println("------------------------------------------------------")	
	}
}

