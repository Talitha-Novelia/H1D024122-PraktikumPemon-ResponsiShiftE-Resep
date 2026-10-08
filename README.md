# 📱 Aplikasi Katalog dan Eksplorasi Resep

> _Aplikasi mobile untuk mencari dan mengeksplorasi resep makanan dari seluruh dunia secara dinamis._

**Nama**: Talitha Novelia Salsabila  
**NIM**: H1D024122
**Shift**: E

---

## 📖 Deskripsi Singkat
Aplikasi Katalog dan Eksplorasi Resep membantu pengguna untuk mencari dan melihat detail berbagai resep makanan dengan mudah melalui perangkat mobile. Aplikasi ini merupakan pemenuhan tugas responsi yang menerapkan pengolahan REST API dinamis dengan pendekatan *state-driven UI* dan *clean architecture*.

## ✨ Fitur Utama
- [x] **Pencarian Data (Search)**: Pengguna dapat mencari resep berdasarkan nama makanan langsung dari halaman utama secara *real-time*.
- [x] **Katalog Resep (Lazy Layout)**: Menampilkan daftar makanan dalam bentuk *grid layout* (gambar, nama, dan kategori).
- [x] **Detail Resep**: Menampilkan informasi lengkap resep makanan termasuk gambar resolusi penuh, kategori, asal negara, daftar bahan masakan (*ingredients*) berserta takaran, dan instruksi memasak.
- [x] **State-Driven UI**: Menangani status *Loading*, *Error* (saat gagal mengambil API), dan *Success* dengan mulus.

## 🏗️ Arsitektur & Teknologi
- **Bahasa**: Kotlin
- **UI Toolkit**: Jetpack Compose (Material Design 3)
- **Arsitektur**: MVVM (Model-View-ViewModel)
- **Networking**: Retrofit dengan Gson Converter
- **Lainnya**: 
  - Coroutines & StateFlow (State management & Asynchronous process)
  - Coil (Image Loading)
  - Navigation Compose (Routing antar halaman)

## 🌐 API yang Digunakan
Aplikasi ini memanfaatkan public API dari TheMealDB (tanpa memerlukan API Key).
- **Nama API**: TheMealDB
- **Dokumentasi**: [TheMealDB API Documentation](https://www.themealdb.com/api.php)
- **Endpoint**:
  - Search: `https://www.themealdb.com/api/json/v1/1/search.php?s={query}`
  - Lookup: `https://www.themealdb.com/api/json/v1/1/lookup.php?i={id}`

## 📸 Tangkapan Layar (Screenshots)

| Home Screen / Search | Loading/Error State | Recipe Detail Screen |
|:---:|:---:|:---:|
| ![Home](<img width="200" alt="image" src="https://github.com/user-attachments/assets/38ed1362-8587-40b8-9e0d-a1132f0a2929" />
) | ![State](<img width="200" alt="image" src="https://github.com/user-attachments/assets/f8237be5-ae25-43a5-92dd-dd05a67cea8a" />
) | ![Detail](<img width="200" alt="image" src="https://github.com/user-attachments/assets/17963093-60cd-434a-9059-2f646961ed83" />
) |

*(Catatan: Ganti gambar di atas dengan screenshot aplikasi yang sebenarnya di dalam folder `docs/`)*

---

## 🚀 Cara Menjalankan Proyek

1. **Prasyarat:**
   - Android Studio (Koala / Ladybug / versi terbaru disarankan).
   - JDK 17 atau lebih baru.
   - Perangkat fisik Android dengan USB Debugging aktif atau Emulator (API level disesuaikan).

2. **Langkah:**
   ```bash
   # Clone repository
   git clone <URL_REPOSITORY>
   ```
3. Buka folder proyek di **Android Studio**.
4. Tunggu proses **Gradle Sync** selesai.
5. Pilih target perangkat/emulator, lalu klik tombol **Run (`Shift + F10`)**.
