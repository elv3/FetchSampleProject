package com.av.fetchrewardssample.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.av.fetchrewardssample.databinding.FragmentComposeViewBinding
import com.av.fetchrewardssample.domain.Item
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentMain: Fragment() {

    private val mainViewModel by viewModels<MainViewModel>()

    private lateinit var binding: FragmentComposeViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentComposeViewBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

            setContent {
                MainScreen()
            }
        }
    }

    @Composable
    private fun MainScreen() {
        val uiState by mainViewModel.uiState.collectAsState()
        Content(uiState)
    }

    @Composable
    private fun Content(
        uiState: Map<Int, List<Item>>
    ) {
        
        val backgroundColors by remember {
            val backgroundColors = listOf(
                Color(0xFF007BFF),
                Color(0xFF28A745),
                Color(0xFFFD7E14),
                Color(0xFFDC3545),
                Color(0xFF6F42C1)
            )
            mutableStateOf(backgroundColors)
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .background(Color(0xFF1A1A1A))
        ) {
            itemsIndexed(uiState.keys.toList(), key = { _, key -> key }) { index, key ->

                val color = backgroundColors[index % backgroundColors.size]

                Card(
                    modifier = Modifier.fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 16.dp)
                        .padding(vertical = 10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = color,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(3.dp)
                ) {

                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .padding(5.dp)
                    ) {
                        Text(text = "Group #$key")

                        val elements = uiState[key] ?: emptyList()
                        StaggeredNames(elements)
                    }

                }
            }
        }
    }

    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    private fun StaggeredNames(elements: List<Item>) {

        FlowRow(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            elements.forEach { child ->
                ChipItem(child.name ?: "")
            }
        }
    }

    @Composable
    fun ChipItem(text: String, onClick: () -> Unit = {}) {
        FilterChip(
            modifier = Modifier.padding(end = 4.dp),
            onClick = onClick,
            leadingIcon = {},
            border = BorderStroke(1.dp, Color(0xFF3B3A3C)),
            colors = FilterChipDefaults.filterChipColors(
                containerColor = Color.White
            ),
            label = {
                Text(text)
            },
            selected = false
        )
    }

    @Preview
    @Composable
    private fun ContentPreview() {

        // Mock data for preview visualization
        val mockListId5 = listOf(
            Item(
                id = 11,
                listId = 5,
                name = "Item 11"
            ),
            Item(
                id = 14,
                listId = 5,
                name = "Item 14"
            ),
            Item(
                id = 17,
                listId = 5,
                name = "Item 17"
            ),
            Item(
                id = 22,
                listId = 5,
                name = "Item 22"
            ),
            Item(
                id = 27,
                listId = 5,
                name = "Item 27"
            ),
            Item(
                id = 31,
                listId = 5,
                name = "Item 31"
            ),
            Item(
                id = 55,
                listId = 5,
                name = "Item 55"
            ),
            Item(
                id = 66,
                listId = 5,
                name = "Item 66"
            )
        )


        MaterialTheme {
            Content(
                uiState = mapOf(
                    4 to mockListId5,
                    8 to mockListId5,
                    5 to mockListId5,
                    1 to mockListId5,
                    7 to mockListId5,
                    3 to mockListId5
                )
            )
        }

    }
}