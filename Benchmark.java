import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Benchmark {

    public static long measure(
            Runnable setup,
            Runnable operation,
            int repetitions) {

        long total = 0;

        for (int i = 0; i < repetitions; i++) {

            setup.run();

            long start = System.nanoTime();

            operation.run();

            long finish = System.nanoTime();

            total += finish - start;
        }

        return total / repetitions;
    }

    public static <T> long run(
            Supplier<T> setup,
            Consumer<T> operation,
            int repetitions) {

        long total = 0;

        for (int i = 0; i < repetitions; i++) {

            T structure = setup.get();

            long start = System.nanoTime();

            operation.accept(structure);

            long finish = System.nanoTime();

            total += finish - start;
        }

        return total / repetitions;
    }

    public static void printResult(
            String structure,
            String method,
            int size,
            long time) {

        System.out.printf(
                Locale.US,
                "%s,%s,%d,%d%n",
                structure,
                method,
                size,
                time
        );
    }

    public static void main(String[] args) {

        int[] sizes = {10, 100, 1000, 10000, 100000};
        int repetitions = 5;

        System.out.println("Estructura,Metodo,Tamano,Tiempo_ns");

        for (int n : sizes) {

            // =====================================================
            // SINGLY LINKED LIST
            // =====================================================

            printResult(
                    "SinglyLinkedList",
                    "pushFront",
                    n,
                    run(
                            () -> new SinglyLinkedList<Integer>(),
                            lista -> lista.pushFront(1),
                            repetitions
                    )
            );

            printResult(
                    "SinglyLinkedList",
                    "pushBack",
                    n,
                    run(
                            () -> new SinglyLinkedList<Integer>(),
                            lista -> lista.pushBack(1),
                            repetitions
                    )
            );

            printResult(
                    "SinglyLinkedList",
                    "popFront",
                    n,
                    run(
                            () -> {
                                SinglyLinkedList<Integer> lista =
                                        new SinglyLinkedList<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.popFront(),
                            repetitions
                    )
            );

            printResult(
                    "SinglyLinkedList",
                    "popBack",
                    n,
                    run(
                            () -> {
                                SinglyLinkedList<Integer> lista =
                                        new SinglyLinkedList<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.popBack(),
                            repetitions
                    )
            );

            printResult(
                    "SinglyLinkedList",
                    "find",
                    n,
                    run(
                            () -> {
                                SinglyLinkedList<Integer> lista =
                                        new SinglyLinkedList<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.find(0),
                            repetitions
                    )
            );

            printResult(
                    "SinglyLinkedList",
                    "erase",
                    n,
                    run(
                            () -> {
                                SinglyLinkedList<Integer> lista =
                                        new SinglyLinkedList<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.erase(0),
                            repetitions
                    )
            );

            printResult(
                    "SinglyLinkedList",
                    "addBefore",
                    n,
                    run(
                            () -> {
                                SinglyLinkedList<Integer> lista =
                                        new SinglyLinkedList<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.addBefore(0, -1),
                            repetitions
                    )
            );

            printResult(
                    "SinglyLinkedList",
                    "addAfter",
                    n,
                    run(
                            () -> {
                                SinglyLinkedList<Integer> lista =
                                        new SinglyLinkedList<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.addAfter(0, -1),
                            repetitions
                    )
            );


            // =====================================================
            // SINGLY LINKED LIST WITH TAIL
            // =====================================================

            printResult(
                    "SinglyLinkedListWithTail",
                    "pushFront",
                    n,
                    run(
                            () -> new SinglyLinkedListWithTail<Integer>(),
                            lista -> lista.pushFront(1),
                            repetitions
                    )
            );

            printResult(
                    "SinglyLinkedListWithTail",
                    "pushBack",
                    n,
                    run(
                            () -> new SinglyLinkedListWithTail<Integer>(),
                            lista -> lista.pushBack(1),
                            repetitions
                    )
            );

            printResult(
                    "SinglyLinkedListWithTail",
                    "popFront",
                    n,
                    run(
                            () -> {
                                SinglyLinkedListWithTail<Integer> lista =
                                        new SinglyLinkedListWithTail<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.popFront(),
                            repetitions
                    )
            );

            printResult(
                    "SinglyLinkedListWithTail",
                    "popBack",
                    n,
                    run(
                            () -> {
                                SinglyLinkedListWithTail<Integer> lista =
                                        new SinglyLinkedListWithTail<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.popBack(),
                            repetitions
                    )
            );

            printResult(
                    "SinglyLinkedListWithTail",
                    "find",
                    n,
                    run(
                            () -> {
                                SinglyLinkedListWithTail<Integer> lista =
                                        new SinglyLinkedListWithTail<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.find(0),
                            repetitions
                    )
            );

            printResult(
                    "SinglyLinkedListWithTail",
                    "erase",
                    n,
                    run(
                            () -> {
                                SinglyLinkedListWithTail<Integer> lista =
                                        new SinglyLinkedListWithTail<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.erase(0),
                            repetitions
                    )
            );

            printResult(
                    "SinglyLinkedListWithTail",
                    "addBefore",
                    n,
                    run(
                            () -> {
                                SinglyLinkedListWithTail<Integer> lista =
                                        new SinglyLinkedListWithTail<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.addBefore(0, -1),
                            repetitions
                    )
            );

            printResult(
                    "SinglyLinkedListWithTail",
                    "addAfter",
                    n,
                    run(
                            () -> {
                                SinglyLinkedListWithTail<Integer> lista =
                                        new SinglyLinkedListWithTail<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.addAfter(0, -1),
                            repetitions
                    )
            );


            // =====================================================
            // DOUBLY LINKED LIST
            // =====================================================

            printResult(
                    "DoublyLinkedList",
                    "pushFront",
                    n,
                    run(
                            () -> new DoublyLinkedList<Integer>(),
                            lista -> lista.pushFront(1),
                            repetitions
                    )
            );

            printResult(
                    "DoublyLinkedList",
                    "pushBack",
                    n,
                    run(
                            () -> new DoublyLinkedList<Integer>(),
                            lista -> lista.pushBack(1),
                            repetitions
                    )
            );

            printResult(
                    "DoublyLinkedList",
                    "popFront",
                    n,
                    run(
                            () -> {
                                DoublyLinkedList<Integer> lista =
                                        new DoublyLinkedList<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.popFront(),
                            repetitions
                    )
            );

            printResult(
                    "DoublyLinkedList",
                    "popBack",
                    n,
                    run(
                            () -> {
                                DoublyLinkedList<Integer> lista =
                                        new DoublyLinkedList<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.popBack(),
                            repetitions
                    )
            );

            printResult(
                    "DoublyLinkedList",
                    "find",
                    n,
                    run(
                            () -> {
                                DoublyLinkedList<Integer> lista =
                                        new DoublyLinkedList<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.find(0),
                            repetitions
                    )
            );

            printResult(
                    "DoublyLinkedList",
                    "erase",
                    n,
                    run(
                            () -> {
                                DoublyLinkedList<Integer> lista =
                                        new DoublyLinkedList<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.erase(0),
                            repetitions
                    )
            );

            printResult(
                    "DoublyLinkedList",
                    "addBefore",
                    n,
                    run(
                            () -> {
                                DoublyLinkedList<Integer> lista =
                                        new DoublyLinkedList<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.addBefore(0, -1),
                            repetitions
                    )
            );

            printResult(
                    "DoublyLinkedList",
                    "addAfter",
                    n,
                    run(
                            () -> {
                                DoublyLinkedList<Integer> lista =
                                        new DoublyLinkedList<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.addAfter(0, -1),
                            repetitions
                    )
            );


            // =====================================================
            // DOUBLY LINKED LIST WITH TAIL
            // =====================================================

            printResult(
                    "DoublyLinkedListWithTail",
                    "pushFront",
                    n,
                    run(
                            () -> new DoublyLinkedListWithTail<Integer>(),
                            lista -> lista.pushFront(1),
                            repetitions
                    )
            );

            printResult(
                    "DoublyLinkedListWithTail",
                    "pushBack",
                    n,
                    run(
                            () -> new DoublyLinkedListWithTail<Integer>(),
                            lista -> lista.pushBack(1),
                            repetitions
                    )
            );

            printResult(
                    "DoublyLinkedListWithTail",
                    "popFront",
                    n,
                    run(
                            () -> {
                                DoublyLinkedListWithTail<Integer> lista =
                                        new DoublyLinkedListWithTail<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.popFront(),
                            repetitions
                    )
            );

            printResult(
                    "DoublyLinkedListWithTail",
                    "popBack",
                    n,
                    run(
                            () -> {
                                DoublyLinkedListWithTail<Integer> lista =
                                        new DoublyLinkedListWithTail<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.popBack(),
                            repetitions
                    )
            );

            printResult(
                    "DoublyLinkedListWithTail",
                    "find",
                    n,
                    run(
                            () -> {
                                DoublyLinkedListWithTail<Integer> lista =
                                        new DoublyLinkedListWithTail<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.find(0),
                            repetitions
                    )
            );

            printResult(
                    "DoublyLinkedListWithTail",
                    "erase",
                    n,
                    run(
                            () -> {
                                DoublyLinkedListWithTail<Integer> lista =
                                        new DoublyLinkedListWithTail<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.erase(0),
                            repetitions
                    )
            );

            printResult(
                    "DoublyLinkedListWithTail",
                    "addBefore",
                    n,
                    run(
                            () -> {
                                DoublyLinkedListWithTail<Integer> lista =
                                        new DoublyLinkedListWithTail<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.addBefore(0, -1),
                            repetitions
                    )
            );

            printResult(
                    "DoublyLinkedListWithTail",
                    "addAfter",
                    n,
                    run(
                            () -> {
                                DoublyLinkedListWithTail<Integer> lista =
                                        new DoublyLinkedListWithTail<>();

                                for (int i = 0; i < n; i++) {
                                    lista.pushFront(i);
                                }

                                return lista;
                            },
                            lista -> lista.addAfter(0, -1),
                            repetitions
                    )
            );


            // =====================================================
            // STACK
            // =====================================================

            printResult(
                    "MyStack",
                    "push",
                    n,
                    run(
                            () -> new MyStack<Integer>(),
                            pila -> pila.push(1),
                            repetitions
                    )
            );

            printResult(
                    "MyStack",
                    "pop",
                    n,
                    run(
                            () -> {
                                MyStack<Integer> pila = new MyStack<>();

                                for (int i = 0; i < n; i++) {
                                    pila.push(i);
                                }

                                return pila;
                            },
                            pila -> pila.pop(),
                            repetitions
                    )
            );

            printResult(
                    "MyStack",
                    "peek",
                    n,
                    run(
                            () -> {
                                MyStack<Integer> pila = new MyStack<>();

                                for (int i = 0; i < n; i++) {
                                    pila.push(i);
                                }

                                return pila;
                            },
                            pila -> pila.peek(),
                            repetitions
                    )
            );


            // =====================================================
            // QUEUE
            // =====================================================

            printResult(
                    "MyQueue",
                    "enqueue",
                    n,
                    run(
                            () -> new MyQueue<Integer>(),
                            cola -> cola.enqueue(1),
                            repetitions
                    )
            );

            printResult(
                    "MyQueue",
                    "dequeue",
                    n,
                    run(
                            () -> {
                                MyQueue<Integer> cola = new MyQueue<>();

                                for (int i = 0; i < n; i++) {
                                    cola.enqueue(i);
                                }

                                return cola;
                            },
                            cola -> cola.dequeue(),
                            repetitions
                    )
            );

            printResult(
                    "MyQueue",
                    "front",
                    n,
                    run(
                            () -> {
                                MyQueue<Integer> cola = new MyQueue<>();

                                for (int i = 0; i < n; i++) {
                                    cola.enqueue(i);
                                }

                                return cola;
                            },
                            cola -> cola.front(),
                            repetitions
                    )
            );
        }
    }
}