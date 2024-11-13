import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var artworkImage: ImageView
    private lateinit var titleText: TextView
    private lateinit var artistText: TextView
    private lateinit var descriptionText: TextView
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button

    private var currentIndex = 0

    private val artworks = listOf(
        Artwork(
            R.drawable.starry_night,
            "The Starry Night",
            "Vincent van Gogh",
            "This painting depicts a night scene with swirling clouds, stars ablaze with their own luminescence, and a bright crescent moon. The scene is dominated by a night sky roiling with chromatic blue swirls, a glowing yellow crescent moon, and stars rendered as radiating orbs. Below the expressive sky is a village with a prominent church spire. To the left, a cypress tree towers over the scene. The village is painted with darker colors but the yellow and white of the stars reflect onto the buildings."
        ),
        Artwork(
            R.drawable.mona_lisa,
            "Mona Lisa",
            "Leonardo da Vinci",
            "The Mona Lisa is an oil painting by Italian artist, inventor, and writer Leonardo da Vinci. Likely completed in 1506, the piece features a portrait of a seated woman set against an imaginary landscape. The woman, believed to be Lisa Gherardini, the wife of Francesco del Giocondo, is dressed in the Florentine fashion of her day and seated in a visionary, mountainous landscape. The painting is known for its subtle modeling of form, atmospheric illusionism, and enigmatic smile."
        ),
        Artwork(
            R.drawable.the_scream,
            "The Scream",
            "Edvard Munch",
            "The Scream is the popular name given to a composition created by Norwegian Expressionist artist Edvard Munch in 1893. The agonized face in the painting has become one of the most iconic images of art, seen as symbolizing the anxiety of the human condition. Munch recalled that he had been out for a walk at sunset when suddenly the setting sun's light turned the clouds 'a blood red'. He sensed an 'infinite scream passing through nature'. The painting shows a figure with an agonized expression against a landscape with a swirling orange sky."
        ),
        Artwork(
            R.drawable.girl_with_pearl_earring,
            "Girl with a Pearl Earring",
            "Johannes Vermeer",
            "Girl with a Pearl Earring is an oil painting by Dutch Golden Age painter Johannes Vermeer, dated c. 1665. The painting is a tronie, the Dutch 17th-century description of a 'head' that was not meant to be a portrait. It depicts a European girl wearing an exotic dress, an oriental turban, and what appears to be a large pearl as an earring. The work has been called the 'Mona Lisa of the North' or the 'Dutch Mona Lisa'. The painting is admired for its striking colors, subtle play of light and shadow, and the enigmatic gaze of the girl."
        ),
        Artwork(
            R.drawable.the_persistence_of_memory,
            "The Persistence of Memory",
            "Salvador Dalí",
            "The Persistence of Memory is a 1931 painting by artist Salvador Dalí, and one of the most recognizable works of Surrealism. First shown at the Julien Levy Gallery in 1932, the painting has been in the collection of the Museum of Modern Art (MoMA) in New York City since 1934. It is widely recognized and frequently referenced in popular culture. The well-known surrealist piece introduced the image of the soft melting pocket watch. It epitomizes Dalí's theory of 'softness' and 'hardness', which was central to his thinking at the time. The painting portrays a dreamscape where time has no meaning."
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        artworkImage = findViewById(R.id.artworkImage)
        titleText = findViewById(R.id.titleText)
        artistText = findViewById(R.id.artistText)
        descriptionText = findViewById(R.id.descriptionText)
        previousButton = findViewById(R.id.previousButton)
        nextButton = findViewById(R.id.nextButton)

        updateArtwork()

        previousButton.setOnClickListener {
            currentIndex = (currentIndex - 1 + artworks.size) % artworks.size
            updateArtwork()
        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % artworks.size
            updateArtwork()
        }
    }

    private fun updateArtwork() {
        val currentArtwork = artworks[currentIndex]
        artworkImage.setImageResource(currentArtwork.imageResourceId)
        titleText.text = currentArtwork.title
        artistText.text = currentArtwork.artist
        descriptionText.text = currentArtwork.description
    }
}