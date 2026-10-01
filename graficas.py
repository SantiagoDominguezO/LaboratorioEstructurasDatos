import pandas as pd
import matplotlib.pyplot as plt

archivo = "resultados.csv"

datos = pd.read_csv(archivo, encoding="utf-16")

operaciones_listas = [
    "pushFront",
    "pushBack",
    "popFront",
    "popBack",
    "find",
    "erase",
    "addBefore",
    "addAfter"
]

for metodo in operaciones_listas:

    datos_metodo = datos[datos["Metodo"] == metodo]

    plt.figure(figsize=(10, 6))

    for estructura in datos_metodo["Estructura"].unique():

        datos_estructura = datos_metodo[
            datos_metodo["Estructura"] == estructura
        ]

        plt.plot(
            datos_estructura["Tamano"],
            datos_estructura["Tiempo_ns"],
            marker="o",
            label=estructura
        )

    plt.title("Tiempo de ejecución - " + metodo)
    plt.xlabel("Tamaño de entrada")
    plt.ylabel("Tiempo (ns)")
    plt.xscale("log")
    plt.yscale("log")
    plt.legend()
    plt.grid(True)

    plt.tight_layout()

    plt.savefig("grafica_" + metodo + ".png", dpi=300)

    plt.close()


# ==========================================================
# STACK
# ==========================================================

for metodo in ["push", "pop", "peek"]:

    datos_metodo = datos[
        (datos["Estructura"] == "MyStack") &
        (datos["Metodo"] == metodo)
    ]

    plt.figure(figsize=(10, 6))

    plt.plot(
        datos_metodo["Tamano"],
        datos_metodo["Tiempo_ns"],
        marker="o"
    )

    plt.title("MyStack - " + metodo)
    plt.xlabel("Tamaño de entrada")
    plt.ylabel("Tiempo (ns)")
    plt.xscale("log")
    plt.yscale("log")
    plt.grid(True)

    plt.tight_layout()

    plt.savefig("grafica_MyStack_" + metodo + ".png", dpi=300)

    plt.close()


# ==========================================================
# QUEUE
# ==========================================================

for metodo in ["enqueue", "dequeue", "front"]:

    datos_metodo = datos[
        (datos["Estructura"] == "MyQueue") &
        (datos["Metodo"] == metodo)
    ]

    plt.figure(figsize=(10, 6))

    plt.plot(
        datos_metodo["Tamano"],
        datos_metodo["Tiempo_ns"],
        marker="o"
    )

    plt.title("MyQueue - " + metodo)
    plt.xlabel("Tamaño de entrada")
    plt.ylabel("Tiempo (ns)")
    plt.xscale("log")
    plt.yscale("log")
    plt.grid(True)

    plt.tight_layout()

    plt.savefig("grafica_MyQueue_" + metodo + ".png", dpi=300)

    plt.close()

print("Gráficas generadas correctamente.")