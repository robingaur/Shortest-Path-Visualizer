package algorithms;

import UtilityClasses.NodeType;
import UtilityClasses.RectangularGrid;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class DijkstraAlgorithm extends AbstractAlgorithms {

    public DijkstraAlgorithm(NodeType[][] graph, int graphWidth, int graphHeight, RectangularGrid grid) {
        super(graph, graphWidth, graphHeight, grid);
    }

    @Override
    void findPath(Point source, Point destination) {
        Queue<Point> queue = new LinkedList<>();
        Point predecessors[][] = new Point[super.graphWidth][super.graphHeight];
        queue.add(source);
        predecessors[(int) source.getX()][(int) source.getY()] = null;

        Point currentPoint;
        while (!queue.isEmpty()) {
            currentPoint = queue.remove();
            int x = (int) currentPoint.getX();
            int y = (int) currentPoint.getY();

            if (currentPoint != source) {
                super.fillVisitedNode(x, y);
            }

            if (x > 0) {
                if (super.graph[x - 1][y] == NodeType.NOT_VISITED) {
                    predecessors[x - 1][y] = currentPoint;
                    queue.add(new Point(x - 1, y));
                    super.graph[x - 1][y] = NodeType.VISITED;
                    super.fillQueueNode(x - 1, y);
                } else if (super.graph[x - 1][y] == NodeType.DESTINATION) {
                    predecessors[x - 1][y] = currentPoint;
                    break;
                }
            }

            if (x <= super.graphWidth) {
                if (super.graph[x + 1][y] == NodeType.NOT_VISITED) {
                    predecessors[x + 1][y] = currentPoint;
                    queue.add(new Point(x + 1, y));
                    super.graph[x + 1][y] = NodeType.VISITED;
                    super.fillQueueNode(x + 1, y);
                } else if (super.graph[x + 1][y] == NodeType.DESTINATION) {
                    predecessors[x + 1][y] = currentPoint;
                    break;
                }
            }

            if (y > 0) {
                if (super.graph[x][y - 1] == NodeType.NOT_VISITED) {
                    predecessors[x][y - 1] = currentPoint;
                    queue.add(new Point(x, y - 1));
                    super.graph[x][y - 1] = NodeType.VISITED;
                    super.fillQueueNode(x, y - 1);
                } else if (super.graph[x][y - 1] == NodeType.DESTINATION) {
                    predecessors[x][y - 1] = currentPoint;
                    break;
                }
            }

            if (y <= super.graphHeight) {
                if (super.graph[x][y + 1] == NodeType.NOT_VISITED) {
                    predecessors[x][y + 1] = currentPoint;
                    queue.add(new Point(x, y + 1));
                    super.graph[x][y + 1] = NodeType.VISITED;
                    super.fillQueueNode(x, y + 1);
                } else if (super.graph[x][y + 1] == NodeType.DESTINATION) {
                    predecessors[x][y + 1] = currentPoint;
                    break;
                }
            }
        }
    }
}
