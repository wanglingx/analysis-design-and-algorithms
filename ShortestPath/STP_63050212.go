package main

import (
	"fmt"
	"strconv"
)
const MaxUint = ^uint(0)
const MaxInt = int(MaxUint >> 1)

var n, c int
var graph = [][]int{{0, 1,2,3,4,5},
					{1, 0,3,5,12,0},
					{2, 3,0,8,0,0},
					{3, 5,8,0,4,9},		
					{4, 12,0,4,0,6},
					{5, 0,0,9,6,0},};
//var graph = [6][6]int{}
var count int = len(graph)
var point int =1
var check = make([]bool, count)
var way = make([]int,count)
var path = make([]string,count)
func main() {
	// fmt.Print("n Node > ")
	// fmt.Scan(&n)
	// for i := 1; i < len(graph); i++ {
	//		graph[0][0] = 0	
	//		graph[i][0] = i	
	// 		N1 := string(rune(i + 65))
	// 	for j := 1; j < len(graph); j++ {
	// 		N2 := string(rune(j + 65))
	// 		fmt.Print("Distance from Node ", N1, " To ", N2, " > ")
	//		graph[0][j] = j
	// 		fmt.Scan(&graph[i][j])
	// 	}
	// 	fmt.Println("-------------------------------")
	// }
	for i := 0; i < len(graph); i++ {
		fmt.Printf("%4d \n", graph[i])
	}
	processSTP();
}


func minimumSorce() int {
	var round int = len(way)
	var vertexMin int = 0;
	var wayMin = MaxInt
	for i:=1;i < round ; i++{
		if !check[i] && way[i] < wayMin{
			wayMin = way[i]
			vertexMin = i
		}
	}
	return vertexMin
}

func processSTP(){
	for i := range check{
		check[i] = false
		way[i] = MaxInt
	}
	way[point] = 0;
	for i:=1;i<count;i++{
		X := minimumSorce();
		check[X] = true;
		for Y :=1 ;Y<count;Y++{
			
			if !check[Y] && graph[X][Y] !=0 && (way[X]+graph[X][Y] < way[Y]){
				way[Y] = way[X] + graph[X][Y]
			}
		}
		display(X);
	}	
}

func display(i int){
		path[0] = "1"
		if i > 2{
			path[i-2] = strconv.Itoa(i)
		}
		fmt.Println("----------------------------------------------")
		fmt.Println("path >> ",path)
		fmt.Printf("This Shortest path have the distance is %d\n",way[i])
		if i >= len(way)-1{
			fmt.Println("------------------------------------------")
			fmt.Println("        Distance is not found")
			fmt.Println("--------end find shortest path---------")
		}
}