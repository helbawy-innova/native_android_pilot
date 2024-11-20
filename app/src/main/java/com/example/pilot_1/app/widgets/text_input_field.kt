package com.example.pilot_1.app.widgets

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pilot_1.R
import com.example.pilot_1.ui.theme.hintTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputField(
    hint: String? = null,
    label: String? = null,
    errorMessage: String? = null,
    onChange: ((String) -> Unit)? = null,
    validator: ((String) -> String)? = null,
    suffix: (@Composable () -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    Log.d("Helbawy", "TextInputField")
    var value by remember {
        mutableStateOf("")
    }

    var isSecured by remember {
        mutableStateOf(keyboardType == KeyboardType.Password)
    }

    var internalErrorMessage by remember{
        mutableStateOf("")
    }

    fun mapSuffix(): (@Composable () -> Unit)? {
        when {
            keyboardType == KeyboardType.Password -> return {
                IconButton(onClick = { isSecured = !isSecured }) {
                    SvgIcon(if (isSecured) R.drawable.visibility else R.drawable.visibility_off)
                }
            }

            suffix != null -> return {
                suffix
            }

            else -> return null
        }
    }
    Column {
        if (!label.isNullOrEmpty()) Text(label)
        if (!label.isNullOrEmpty()) SizedBox(height = 4.0)
        OutlinedTextField(
            value = value,
            trailingIcon = mapSuffix(),
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.fillMaxWidth(),
            isError = (errorMessage?:internalErrorMessage).isNotEmpty(),
            visualTransformation = if (isSecured) PasswordVisualTransformation() else VisualTransformation.None,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            placeholder = {
                if (!hint.isNullOrEmpty()) Text(hint, color = hintTextColor)
            },
            onValueChange = {
                value = it
                onChange?.invoke(it)
                if(validator!=null)internalErrorMessage = validator(value)
            },
        )
        if ((errorMessage?:internalErrorMessage).isNotEmpty()) SizedBox(height = 8.0)
        if ((errorMessage?:internalErrorMessage).isNotEmpty()) {
            Text(
                text = errorMessage?:internalErrorMessage,
                color = MaterialTheme.colorScheme.error,
                fontSize = 12.sp
            )
        }
    }

}