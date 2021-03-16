import kotlinx.html.id
import kotlinx.html.role
import react.RBuilder
import react.RProps
import react.child
import react.dom.div
import react.functionalComponent
import react.table.useTable
import kotlin.random.Random


external interface TableReactJsProps : RProps {
    var title: String
}

fun RBuilder.tableReactJs(handler: TableReactJsProps.() -> Unit) = child(tableReactJs) {
    attrs {
        handler()
    }
}

private val tableReactJs =  functionalComponent<TableReactJsProps> { props ->
    useTable()
    div("table-responsive table mt-2" ){
        attrs{
            id="dataTable"
            role="grid"
        }

    }
}



fun range (len : Int) : List<Int>{
    val arr = mutableListOf<Int>()
    for( i in 0 .. len) {
        arr.add(i)
    }
    return arr
}


fun newPerson () : Person {
    val statusChance = Random.nextInt(0, 100)
    return Person("pippo${statusChance}",
                    "rr${statusChance}",
                    statusChance,
                    2*statusChance,
                    3*statusChance,
                    statusChance/3.4)
}


data class Person(val firstName: String,
                  val lastName :String,
                  val age : Int,
                  val visits : Int,
                  val progress : Int,
                  val status : Double
)

fun makeData(lens : Int) : List<Person> {
       return range (lens).map {
        newPerson ()
    }
}