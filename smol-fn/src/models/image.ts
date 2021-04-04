export interface PictureMetadata {
  id?: number;
  name?: string;
  height?: number;
  width?: number;
  originalDate?: Date;
}

export interface Image {
  id?: number;
  date?: Date;
  image?: string | any;
  pictureMetadata?: PictureMetadata;

}
