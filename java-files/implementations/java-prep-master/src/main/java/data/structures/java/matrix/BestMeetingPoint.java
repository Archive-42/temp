package data.structures.java.matrix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BestMeetingPoint
{
  // A group of two or more people wants to meet and minimize the total travel distance.
  // You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
  // The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|
  /*
  For example:
        {1, 0, 0, 0, 1},
        {0, 1, 0, 1, 0},
        {0, 0, 1, 0, 0}

  Result = 3 + 3 + 1 + 1 + 1 = 9

  rowList: 0, 0, 1, 1, 2
  colList: 0, 4, 1, 3, 2 -> Sorted -> 0, 1, 2, 3, 4
  midRow = 1
  midCol = 2

  To understand why this works:
    Consider all people lined up in a single row
          1     1       1                       1                     1
    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
    The best point to meet is the location of the person in the middle, at position 10.
    This fact can be easily observed when considering 3 people:
    1       1                       1
    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
    If we chose the center point (7), the shorter walk of the last person would be cancelled by a longer walk
    of the first person and, in addition, we had to make moves by the middle person.

  */

  private int[][] grid;
  public BestMeetingPoint(int[][] grid)
  {
    this.grid = grid;
  }

  public int minTotalDistance()
  {
    List<Integer> rowList = new ArrayList<>();
    List<Integer> colList = new ArrayList<>();

    int rows = grid.length;
    int cols = grid[0].length;
    for(int row = 0; row < rows; ++row)
    {
      for(int col = 0; col < cols; ++col)
      {
        if(grid[row][col] == 1)
        {
          rowList.add(row);
          colList.add(col);
        }
      }
    }

    int sum = 0;
    int midRow = rowList.get(rowList.size() / 2);
    for(int row : rowList)
    {
      sum += Math.abs(row - midRow);
    }

    colList.sort(Comparator.naturalOrder());
    int midCol = colList.get(colList.size() / 2);
    for(int col : colList)
    {
      sum += Math.abs(col - midCol);
    }
    return sum;
  }
}
