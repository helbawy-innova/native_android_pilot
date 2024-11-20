package com.example.pilot_1.app.widgets

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

interface ListView{
    companion object{
        @Composable
        fun Separated(
            itemCount:Int,
            itemBuilder: (index:Int) -> @Composable () -> Unit,
            separator: @Composable () -> Unit,
            contentPadding: PaddingValues? = null,
        ){
            LazyColumn(
                contentPadding = contentPadding?:PaddingValues(0.dp)
            ){
                items(itemCount){ index ->
                    itemBuilder(index)()
                    if(index < itemCount - 1){
                        separator()
                    }
                }
            }
        }

        @Composable
        fun Builder(
            itemCount:Int,
            itemBuilder: (index:Int) -> @Composable () -> Unit,
            contentPadding: PaddingValues? = null,
        ){
            LazyColumn(
                contentPadding = contentPadding?:PaddingValues(0.dp)
            ){
                items(itemCount){ index ->
                    itemBuilder(index)()
                }
            }
        }

        @Composable
        fun Random(
            items:  LazyListScope.() -> Unit,
            contentPadding: PaddingValues? = null,
        ){
            LazyColumn(
                contentPadding = contentPadding?:PaddingValues(0.dp)
            ){
                items()
            }
        }
    }
}