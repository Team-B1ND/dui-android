<p align="center">
  <img src="./assets/dui_banner.png" width="100%" alt="dui_banner" />
</p>


![version](https://img.shields.io/badge/version-1.0.4-blue)
[![Tests](https://github.com/Team-B1ND/dui-android/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/Team-B1ND/dui-android/actions)

> ๐ก **DUI๋?** </br>
> DUI๋ Dodam UI๋ก ๋๋ด๋๋ด Android Design System ์๋๋ค. </br>
> Jetpack Compose๋ก ๊ฐ๋ฐ๋์์ผ๋ฉฐ ๋ฒํผ, ์บ๋ฆฐ๋ ๋ฑ ๋ค์ํ ์ปดํฌ๋ํธ๋ฅผ ์ ๊ณตํฉ๋๋ค. </br>

๋๋ด๋๋ด, ๋๋ด Teacher, DAuth์ ์ผ๊ด๋ UI๋ฅผ ์ ์ฉํ๊ธฐ ์ํด์ ๊ฐ๋ฐ๋์์ต๋๋ค.</br>
DUI์ ๊ฐ๋ฐ ๊ณผ์ ์ ๋ณด๊ณ  ์ถ๋ค๋ฉด? ([Dodam Android Design System(DUI)](https://minjae1230.notion.site/Dodam-Android-Design-System-DUI-2e6afc9b205d4f37be5d7b8230136c81))

## FEATURE โก๏ธ
[DUI ์ฌ์ฉ ๊ฐ์ด๋](https://minjae1230.notion.site/DUI-GUIDE-f9fac16ca7df4718b68328e83db9479f)</br></br>
[Foundation](https://minjae1230.notion.site/Foundation-d61c793338b744bd93047958a8caba89)</br>
  - icon
  - shape
  - color
  - typo
 ---
[Component](https://minjae1230.notion.site/Component-fcb2c8d585db4c4ab600b7cffa53ff0c)
  - basic
  - set
  - organization

## PLAYGROUND ๐
app ๋ชจ๋์ ๋น๋ํ์ฌ Preview๋ฅผ ๋ณผ ์ ์์ต๋๋ค.</br>
[dui-android/app at develop ยท Team-B1ND/dui-android](https://github.com/Team-B1ND/dui-android/tree/develop/app)

## TEAM ๐
B1ND-ANDROID</br>
| ๊ฐ๋ฐ์ | ๋ด๋น |
| --- | --- |
| **์ต๋ฏผ์ฌ** [@snack655](https://github.com/snack655) | [DUI COMPONENTS](https://github.com/Team-B1ND/dui-android/tree/main/dodam-components) |
| **๊น๋ํ** [@kdh1123](https://github.com/kdh1123) | [DUI PLAYGROUND](https://github.com/Team-B1ND/dui-android/tree/main/app) |

## START  โฌ๏ธ
in your project
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

module
```gradle
dependencies {
  implementation 'com.github.Team-B1ND:dui-android:{version}'
}
```
