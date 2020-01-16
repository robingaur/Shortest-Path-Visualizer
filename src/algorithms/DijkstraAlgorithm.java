package algorithms;

import UtilityClasses.NodeType;
import UtilityClasses.RectangularGrid;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class DijkstraAlgorithm extends AbstractAlgorithms {

    public DijkstraAlgorithm(NodeType[][] graph, RectangularGrid grid,
                             Point source, Point destination) {
        super(graph, grid, source, destination);
    }

    @Override
    void findPath() {
        Queue<Point> queue = new LinkedList<>();
        Point predecessors[][] = new Point[super.graphWidth][super.graphHeight];
        queue.add(super.source);

        // no predecessor for source node.
        predecessors[(int) super.source.getX()][(int) super.source.getY()] = null;

        Point currentPoint;
        while (!queue.isEmpty()) {
            currentPoint = queue.remove();
            int x = (int) currentPoint.getX();
            int y = (int) currentPoint.getY();

            if (currentPoint != super.source) {
                super.graph[x][y] = NodeType.VISITED;
                super.fillVisitedNode(x, y);
            }

            if (x > 0) {
                if (super.graph[x - 1][y] == NodeType.NOT_VISITED) {
                    predecessors[x - 1][y] = currentPoint;
                    queue.add(new Point(x - 1, y));
                    super.graph[x - 1][y] = NodeType.IN_QUEUE;
                    super.fillQueueNode(x - 1, y);
                } else if (super.graph[x - 1][y] == NodeType.DESTINATION) {
                    predecessors[x - 1][y] = currentPoint;
                    break;
                }
            }

            if (x < super.graphWidth - 1) {
                if (super.graph[x + 1][y] == NodeType.NOT_VISITED) {
                    predecessors[x + 1][y] = currentPoint;
                    queue.add(new Point(x + 1, y));
                    super.graph[x + 1][y] = NodeType.IN_QUEUE;
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
                    super.graph[x][y - 1] = NodeType.IN_QUEUE;
                    super.fillQueueNode(x, y - 1);
                } else if (super.graph[x][y - 1] == NodeType.DESTINATION) {
                    predecessors[x][y - 1] = currentPoint;
                    break;
                }
            }

            if (y < super.graphHeight - 1) {
                if (super.graph[x][y + 1] == NodeType.NOT_VISITED) {
                    predecessors[x][y + 1] = currentPoint;
                    queue.add(new Point(x, y + 1));
                    super.graph[x][y + 1] = NodeType.IN_QUEUE;
                    super.fillQueueNode(x, y + 1);
                } else if (super.graph[x][y + 1] == NodeType.DESTINATION) {
                    predecessors[x][y + 1] = currentPoint;
                    break;
                }
            }
        }

        Point node = predecessors[(int) super.destination.getX()][(int) super.destination.getY()];
        Point tempNode;
        if (node == null) {

        } else {
            while (super.graph[(int) node.getX()][(int) node.getY()] != NodeType.SOURCE) {
                super.fillPathNode((int) node.getX(), (int) node.getY());
                tempNode = predecessors[(int) node.getX()][(int) node.getY()];
                node = tempNode;
            }
        }
    }
}
