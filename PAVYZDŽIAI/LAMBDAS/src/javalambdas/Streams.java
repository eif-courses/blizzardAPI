/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalambdas;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 *
 * @author Marius
 */
public class Streams  {
    private enum Status {
        OPEN, CLOSED
    };
    
    private static final class Task {
        private final Status status;
        private final Integer points;

        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }
        
        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }
    final Collection< Task > tasks = Arrays.asList(
        new Task( Status.OPEN, 100 ),
        new Task( Status.OPEN, 10 ),
        new Task( Status.CLOSED, 20 ),
        new Task( Status.OPEN, 10 ),
        new Task( Status.OPEN, 10 ),
        new Task( Status.OPEN, 5 ),
        new Task( Status.OPEN, 5 ),
        new Task( Status.OPEN, 10 ),
        new Task( Status.CLOSED, 20 ),
        new Task( Status.OPEN, 20 ),
        new Task( Status.OPEN, 10 )        
    );
    public String printOpenTaskList(){
        final long totalPointsOfOpenTasks = tasks
                .stream()
                .filter( task -> task.getStatus() == Status.OPEN )
                .mapToInt( Task::getPoints )
                .sum();
        System.out.println( "\033[34m Total points: " + totalPointsOfOpenTasks +"\n Task list: " +tasks);
          return "TOTAL OPEN TASKS: "+totalPointsOfOpenTasks + "\n Task List: "+tasks;
    }
    public String printParralelTaskList(){
        final long totalPoints = tasks
                .stream()
                .parallel()
                .map(Task::getPoints)
                .reduce(0, Integer::sum);
        System.out.println("\033[34m All tasks total points: "+totalPoints+" \nTask list:"+tasks);
        return "ALL TASKS: "+totalPoints + "\n Task List: "+tasks;
    }
    public String orderByTask(){
        final Map< Status, List< Task > > map = tasks
        .stream()
        .collect( Collectors.groupingBy( Task::getStatus ) 
        );
        System.out.println("\033[34m GROUPED TASKS: \n"+map);
    return "GROUPED TASKS:\n "+map;
    }
    public String calculateTaskWeight(){
        // Calculate total points of all tasks
        final double totalPoints = tasks
                .stream()
                .parallel()
                .map( task -> task.getPoints() ) // or map( Task::getPoints )
                .reduce( 0, Integer::sum );
        // Calculate the weight of each tasks (as percent of total points) 
        final Collection< String > result = tasks
                .stream()                                        // Stream< String >
                .mapToInt( Task::getPoints )                     // IntStream
                .asLongStream()                                  // LongStream
                .mapToDouble( points -> points / totalPoints )   // DoubleStream
                .boxed()                                         // Stream< Double >
                .mapToLong( weigth -> ( long )( weigth * 100 ) ) // LongStream
                .mapToObj( percentage -> percentage + "%" )      // Stream< String> 
                .collect( Collectors.toList() );                 // List< String >         
        System.out.println( result );
    return ""+result;
    }
}
