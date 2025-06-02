# MVI Playground – Android App with Jetpack Compose

This project showcases the use of the **Model-View-Intent (MVI)** architecture pattern in an Android app using **Jetpack Compose**.

---

## What is MVI?

<p align="center">
  <img src="https://miro.medium.com/v2/resize:fit:1100/format:webp/1*yqiynGx9AADPPT52b37idQ.png" alt="MVI Architecture" width="700"/>
</p>



**MVI (Model-View-Intent)** is an architectural pattern designed to enforce **unidirectional data flow** and **clear state management** in UI applications. It helps maintain a **single source of truth** (state), separates UI from business logic, and makes state transitions explicit and predictable.

### Core Concepts:

- **Model**: The source of truth – represents the current UI state.
- **View**: A stateless UI that renders based on the current state.
- **Intent**: User actions or events that describe a change request.

---

## Why MVI over MVVM?

While **MVVM (Model-View-ViewModel)** is widely used in Android, **MVI** can be a better fit in certain cases, especially with **Jetpack Compose**.

| Feature                  | MVVM                              | MVI                                                   |
|--------------------------|------------------------------------|--------------------------------------------------------|
| **Data Flow**           | Bidirectional                     | Unidirectional                                         |
| **State Management**     | Multiple sources (LiveData/StateFlow) | Single source of truth (ViewState)                    |
| **UI Logic in View**     | Can sneak into the ViewModel      | Strictly separated into reducer and intent handling   |
| **UI Event Handling**    | Often handled in ViewModel        | Explicit `Intent` and `Effect` models                 |
| **Debuggability**        | Can be hard to trace              | Easier with explicit state transitions                |
| **Suitability for Compose** | Requires adjustments              | Natural fit for declarative UI and state-driven views |

### Why Prefer MVI:
- Encourages **predictable state transitions**.
- Minimizes **shared mutable state** and race conditions.
- Promotes **pure functions** and clear intent–state flow.
- Makes it [easier to reason about UI behavior and debug issues](https://medium.com/bumble-tech/a-modern-kotlin-based-mvi-architecture-9924e08efab1)
- Ideal for **complex UIs** with multiple states and one-off events.

---

## Learning Resources and References

Below are articles that inspired this implementation and helped shape the structure of this MVI Playground:

### 1. [Android Simple MVI Implementation with Jetpack Compose](https://medium.com/@VolodymyrSch/android-simple-mvi-implementation-with-jetpack-compose-5ee5d6fc4908)
### 2. [A Robust MVI with Jetpack Compose](https://proandroiddev.com/a-robust-mvi-with-jetpack-compose-e08882d2c4ff)
### 3. [Passive Views – Keep Your UI Code Simple and Stupid](https://proandroiddev.com/passive-views-keep-your-ui-code-simple-and-stupid-part-2-ec7ee456167c)


