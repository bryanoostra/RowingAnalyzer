import io.reactivex.disposables.CompositeDisposable
import methods.Util
import org.omg.CORBA.portable.UnknownException
import wrapper.RowTrainingPart
import wrapper.RowingTraining

class RowingAnalyzer(
      val applicationComponent: ApplicationComponent
) {
    private val disposables = CompositeDisposable()

    fun init() {
        val docs = arrayOf("18-03-2017", "20-03-2017", "22-03-2017", "26-03-2017", "27-03-2017")
        for(doc in docs) {
            val training = RowingTraining(doc)
            disposables += applicationComponent.trainingReader.readTraining(doc + ".csv").subscribe { string ->
                try {
                    val part = RowTrainingPart(string)
                    training.add(part)
                    //println(string)
                } catch (e: UnknownException) {
                    //println("Invalid input")
                    //println(string)
                }
            }
            println(training)
            println("18-22\t\t\t22-26\t\t\t26-30\t\t\t30+")
            print(Util.timeToString(training.getPaceForBin(18, 22)))
            print("\t\t")
            print(Util.timeToString(training.getPaceForBin(22, 26)))
            print("\t\t")
            print(Util.timeToString(training.getPaceForBin(26, 30)))
            print("\t\t")
            println(Util.timeToString(training.getPaceForBin(30, Integer.MAX_VALUE)))
            println()
        }
        disposables.dispose()
    }
}
