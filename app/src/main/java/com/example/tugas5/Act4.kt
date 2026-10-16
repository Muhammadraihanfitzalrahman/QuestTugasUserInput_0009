package com.example.tugas5

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tugas5.ui.theme.Tugas5Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormBiodataScreen(modifier: Modifier = Modifier) {
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }
    var selectedExperience by remember { mutableStateOf("") }
    var isExperienceExpanded by remember { mutableStateOf(false) }

    var isAndroidChecked by remember { mutableStateOf(false) }
    var isUiUxChecked by remember { mutableStateOf(false) }
    var isWebChecked by remember { mutableStateOf(false) }

    val experienceOptions = stringArrayResource(id = R.array.experience_options)

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(colorResource(id = R.color.screen_background))
        ) {
            // Background Header Image (Tema Kupu-Kupu Neon Wall)
            Image(
                painter = painterResource(id = R.drawable.img_butterfly_header),
                contentDescription = stringResource(id = R.string.desc_header_bg),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.header_height))
            )

            // Floating Box / Container over Scaffold
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.card_top_offset)))

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(
                        topStart = dimensionResource(id = R.dimen.card_corner_radius),
                        topEnd = dimensionResource(id = R.dimen.card_corner_radius)
                    ),
                    color = colorResource(id = R.color.card_background),
                    shadowElevation = dimensionResource(id = R.dimen.card_elevation)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(dimensionResource(id = R.dimen.padding_large)),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacing_large))
                    ) {
                        // Title
                        Text(
                            text = stringResource(id = R.string.title_form_biodata),
                            style = TextStyle(
                                fontSize = dimensionResource(id = R.dimen.font_size_title).value.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.form_title_purple)
                            )
                        )

                        // Subtitle
                        Text(
                            text = stringResource(id = R.string.subtitle_form_biodata),
                            style = TextStyle(
                                fontSize = dimensionResource(id = R.dimen.font_size_subtitle).value.sp,
                                color = colorResource(id = R.color.form_subtitle_gray)
                            )
                        )

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_xs)))

                        // Nama Depan & Nama Belakang
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacing_small))
                        ) {
                            OutlinedTextField(
                                value = namaDepan,
                                onValueChange = { namaDepan = it },
                                label = { Text(text = stringResource(id = R.string.label_nama_depan)) },
                                singleLine = true,
                                shape = RoundedCornerShape(dimensionResource(id = R.dimen.input_corner_radius)),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = colorResource(id = R.color.input_outline_color),
                                    unfocusedBorderColor = colorResource(id = R.color.input_outline_color)
                                ),
                                modifier = Modifier.weight(1f)
                            )

                            OutlinedTextField(
                                value = namaBelakang,
                                onValueChange = { namaBelakang = it },
                                label = { Text(text = stringResource(id = R.string.label_nama_belakang)) },
                                singleLine = true,
                                shape = RoundedCornerShape(dimensionResource(id = R.dimen.input_corner_radius)),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = colorResource(id = R.color.input_outline_color),
                                    unfocusedBorderColor = colorResource(id = R.color.input_outline_color)
                                ),
                                modifier = Modifier.weight(1f)
                            )
                        }

                        // Email
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text(text = stringResource(id = R.string.label_email)) },
                            singleLine = true,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.input_corner_radius)),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(id = R.color.input_outline_color),
                                unfocusedBorderColor = colorResource(id = R.color.input_outline_color)
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )

                        // Tgl Lahir & Experience
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacing_small))
                        ) {
                            OutlinedTextField(
                                value = tglLahir,
                                onValueChange = { tglLahir = it },
                                label = { Text(text = stringResource(id = R.string.label_tgl_lahir)) },
                                singleLine = true,
                                shape = RoundedCornerShape(dimensionResource(id = R.dimen.input_corner_radius)),
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_calendar),
                                        contentDescription = stringResource(id = R.string.desc_calendar_icon),
                                        tint = colorResource(id = R.color.input_outline_color)
                                    )
                                },
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = colorResource(id = R.color.input_outline_color),
                                    unfocusedBorderColor = colorResource(id = R.color.input_outline_color)
                                ),
                                modifier = Modifier.weight(1f)
                            )

                            ExposedDropdownMenuBox(
                                expanded = isExperienceExpanded,
                                onExpandedChange = { isExperienceExpanded = !isExperienceExpanded },
                                modifier = Modifier.weight(1f)
                            ) {
                                OutlinedTextField(
                                    value = selectedExperience,
                                    onValueChange = {},
                                    readOnly = true,
                                    label = { Text(text = stringResource(id = R.string.label_experience)) },
                                    singleLine = true,
                                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.input_corner_radius)),
                                    trailingIcon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_arrow_drop_down),
                                            contentDescription = stringResource(id = R.string.desc_dropdown_icon),
                                            tint = colorResource(id = R.color.input_outline_color)
                                        )
                                    },
                                    colors = OutlinedTextFieldDefaults.colors(
                                        focusedBorderColor = colorResource(id = R.color.input_outline_color),
                                        unfocusedBorderColor = colorResource(id = R.color.input_outline_color)
                                    ),
                                    modifier = Modifier.menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
                                )

                                ExposedDropdownMenu(
                                    expanded = isExperienceExpanded,
                                    onDismissRequest = { isExperienceExpanded = false }
                                ) {
                                    experienceOptions.forEach { option ->
                                        DropdownMenuItem(
                                            text = { Text(text = option) },
                                            onClick = {
                                                selectedExperience = option
                                                isExperienceExpanded = false
                                            }
                                        )
                                    }
                                }
                            }
                        }

                        // Pilih Skill Anda
                        Text(
                            text = stringResource(id = R.string.label_pilih_skill),
                            style = TextStyle(
                                fontSize = dimensionResource(id = R.dimen.font_size_section).value.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.text_dark)
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = dimensionResource(id = R.dimen.spacing_xs))
                        )

                        // Checkboxes
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.clickable { isAndroidChecked = !isAndroidChecked }
                            ) {
                                Checkbox(
                                    checked = isAndroidChecked,
                                    onCheckedChange = { isAndroidChecked = it }
                                )
                                Text(
                                    text = stringResource(id = R.string.skill_android),
                                    style = TextStyle(
                                        fontSize = dimensionResource(id = R.dimen.font_size_body).value.sp,
                                        color = colorResource(id = R.color.text_dark)
                                    )
                                )
                            }

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.clickable { isUiUxChecked = !isUiUxChecked }
                            ) {
                                Checkbox(
                                    checked = isUiUxChecked,
                                    onCheckedChange = { isUiUxChecked = it }
                                )
                                Text(
                                    text = stringResource(id = R.string.skill_uiux),
                                    style = TextStyle(
                                        fontSize = dimensionResource(id = R.dimen.font_size_body).value.sp,
                                        color = colorResource(id = R.color.text_dark)
                                    )
                                )
                            }

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.clickable { isWebChecked = !isWebChecked }
                            ) {
                                Checkbox(
                                    checked = isWebChecked,
                                    onCheckedChange = { isWebChecked = it }
                                )
                                Text(
                                    text = stringResource(id = R.string.skill_web),
                                    style = TextStyle(
                                        fontSize = dimensionResource(id = R.dimen.font_size_body).value.sp,
                                        color = colorResource(id = R.color.text_dark)
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_xs)))

                        // Button Proceed
                        val isFormValid = namaDepan.isNotEmpty() || namaBelakang.isNotEmpty() || email.isNotEmpty()
                        Button(
                            onClick = { },
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isFormValid) colorResource(id = R.color.button_active_bg) else colorResource(id = R.color.button_disabled_bg),
                                contentColor = if (isFormValid) colorResource(id = R.color.button_active_text) else colorResource(id = R.color.button_disabled_text)
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(dimensionResource(id = R.dimen.button_height))
                        ) {
                            Text(
                                text = stringResource(id = R.string.btn_proceed),
                                style = TextStyle(
                                    fontSize = dimensionResource(id = R.dimen.font_size_button).value.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isFormValid) colorResource(id = R.color.button_active_text) else colorResource(id = R.color.button_disabled_text)
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormBiodataScreenPreview() {
    Tugas5Theme {
        FormBiodataScreen()
    }
}
