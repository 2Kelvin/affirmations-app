# affirmations-app

![affirmation](https://github.com/2Kelvin/affirmations-app/assets/85868026/995ae41c-8b6f-42e8-9e2e-cd6f706b27f7)

## FutureMe Notes

- use `enum classes` to specify a fixed number of options. The options are called constants. They are (objects) and are declared in caps.
    ```kotlin
    enum class Sport {
        BASKETBALL, FOOTBALL, RALLY
    }
    ```
- use a `data class` to create objects with no methods, only properties
    ```kotlin
    data class Player (
        val name: String,
        val sport: Sport,
        val team: String,
    )
    ```
- use a regular class to create objects with properties and methods
- use a `LazyColumn` to display a scrollable list of items
    ```kotlin
    LazyColumn {
        // pass the list of items to display to items property
        items(affirmationList) {listItem ->
            // items property lambda function iterates over each list item in the list
            // and passes each one to a reusable AffirmationCard to be displayed in the UI
            AffirmationCard(affirmationObj = listItem)
        }
    }
    ```